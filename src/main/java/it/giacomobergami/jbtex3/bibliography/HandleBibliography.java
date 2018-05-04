/*
 * HandleBibliography.java
 * This file is part of jbtex3
 *
 * Copyright (C) 2018 giacomo
 *
 * jbtex3 is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * jbtex3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jbtex3. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package it.giacomobergami.jbtex3.bibliography;

import it.giacomobergami.jbtex3.bibliography.legacy.BBLRepresent;
import it.giacomobergami.jbtex3.bibliography.legacy.HandleBibliographyLegacy;
import it.giacomobergami.jbtex3.legacy_latex.jbtex.ProjectConfiguration;
import it.giacomobergami.jbtex3.legacy_latex.tex.TexWalker;
import org.jbibtex.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class HandleBibliography  {

    BBLRepresent bbl;
    BibtexFile bf;
    String folder;
    String texFile;

    public HandleBibliography(String mainTexFile, String bibliographyFile) throws FileNotFoundException, ParseException {
        texFile = mainTexFile;
        File bblFile = new File(mainTexFile.replace(".tex",".bbl"));
        bbl = new BBLRepresent(bblFile);
        folder = bblFile.getParent();
        bf = new BibtexFile(new File(bibliographyFile));
    }

    public HandleBibliography() throws FileNotFoundException, ParseException {
        this(ProjectConfiguration.configuration.getProperty("main","main.tex"),
                ProjectConfiguration.configuration.getProperty("bib","main.bib"));
    }

    /**
     * Replaces all the bibitems by just one element
     * @param toKeep    Bibitems generated in the bbl file, as provided in the Bibliography
     * @param trm       Bibitems (as above) to be replaced with the toKeep element
     */
    public void removeWith(String toKeep, String... trm) {
        toKeep = toKeep.replace("+","{\\etalchar{+}}");
        String item;
        if ((item = bbl.seekBibitemFromGenerated(toKeep)) != null) {
            toKeep = item;
        }
        List<String> lm = new ArrayList<>();
        for (String k : trm) {
            k = k.replace("+","{\\etalchar{+}}");
            if ((item = bbl.seekBibitemFromGenerated(k)) != null) {
                lm.add(item);
                bf.removeEntry(item);
            }
        }
        try {
            for (File f : new TexWalker(texFile).walk()) {
                String fStr = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
                for (String k : lm) {
                    fStr = fStr.replaceAll(k,toKeep);
                }
                Files.write(f.toPath(), fStr.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves the changes apported to the tex files
     * @throws IOException
     */
    public void saveBibliographyFile() throws IOException {
        bf.save(true);
    }

    /**
     * Remove the duplicates automatically
     * @throws IOException
     */
    public void removeDuplicates() throws IOException {
        bbl.uniformKeysWithSameValue().forEach(l -> {
            ArrayList<String> toRemove = new ArrayList<>(l.size());
            toRemove.addAll(l);
            String main = toRemove.remove(0);
            for (String k : toRemove) {
                bf.removeEntry(k);
            }
        });

        try {
            for (File f : new TexWalker(texFile).walk()) {
                String fStr = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
                Iterable<Collection<String>> it = () -> bbl.uniformKeysWithSameValue().iterator();
                for (Collection<String> l : it) {
                    ArrayList<String> toRemove = new ArrayList<>(l.size());
                    toRemove.addAll(l);
                    String main = toRemove.remove(0);
                    for (String k : toRemove) {
                        fStr = fStr.replaceAll("\\\\cite\\{"+k+"\\}","\\cite{"+main+"}");
                    }
                }
                Files.write(f.toPath(), fStr.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bf.save(false);
    }

    /**
     * Returns...
     * @return ... a collection of elements that are not matched
     * @throws IOException
     */
    public Set<String> getMissingCitationWarning() throws IOException {
        Set<String> toret;
        {
            Set<String> missings = HandleBibliographyLegacy.getMissingsLegacy(texFile);
            Iterator<File> fileWithMissingElements = HandleBibliographyLegacy.getFilesWithMissingsLegacy(missings, texFile);

            Set<String> notMatched = new HashSet<>();
            notMatched.addAll(missings);
            while (fileWithMissingElements.hasNext()) {
                File f = fileWithMissingElements.next();
                String k = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
                for (String x : missings) {
                    if (k.contains(x))
                        notMatched.remove(x);
                }
            }

            toret = new HashSet<>(missings);
            toret.removeAll(notMatched);
        }

        return toret;
    }

    /**
     * Given all the elemnets that are not matched within the tex files, it replaces them by the elemnets directly imputed by the user
     * @throws IOException
     */
    public void imputeReallyToBeReplacedItems() throws IOException {
        HashMap<String, String> oldToNew = new HashMap<>();
        Scanner input = new Scanner(System.in);
        for (String missing : getMissingCitationWarning()) {
            System.out.println("Replace missing " + missing + " with:");
            String toreplace = input.nextLine();
            oldToNew.put(missing, toreplace);
        }
        if (!oldToNew.isEmpty()) for (File f : new TexWalker(texFile).walk()) {
            String fStr = new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8);
            for (Map.Entry<String, String> l : oldToNew.entrySet()) {
                fStr = fStr.replaceAll(l.getKey(),l.getValue());
            }
            Files.write(f.toPath(), fStr.getBytes());
        }
    }

    public static void main(String args[]) {
        try  {
            HandleBibliography hb = new HandleBibliography("/mnt/DEC4763AC47614CD/thesis/main.tex","/mnt/DEC4763AC47614CD/thesis/mbib.bib");
            hb.imputeReallyToBeReplacedItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
