# jbTeX3

jbTeX3 is a spin off of jbTeX2 after an intensive use of LaTeX. At the time of the writing, academia heavely uses LaTeX for formatting papers, but LaTeX has the following issues:
 * *Different conferences have different requirements for defining Author, Title, Abstract and Keyword information.*

     If I want to resubmit the same paper to different conferences, I have to do some major rewriting pre-processing. This goal can be achieved by using XML as a meta-markup language and using XQuery/Antlr4 for matching XML information and rewriting into tex sources.
 * As a consequence of the former remark, I want to generate plain text representation in a semantic-aware form.
 * We can use the FileSystem to dictate the file-inclusion order for the different article's parts, without using `\input` or `\include` directives.
 

## Installing dependencies

This project uses Oracle's XQuery interpreter. For this reason, we advise each user to register himself to Oracle, and then run the `install-dependencies.sh` script to download and maven-install the required libraries. The complete installation process is provided by either `linux-install.sh` or `macos-install.sh` scripts. After running such scripts, the `jbTeX3.sh` can be run to use the program from command line.

**TODO** Add a GUI Wizard to guide in the rewriting process.

## Paper structure

Each paper is defined by a ``paper`` folder, where the paper is written in XML format, and ``information.xml`` containing the title, author and conference/journal information. An example of the expected folder structure is provided by the root folder of this project.

## Stylesheets

Each folder `x` in `queries` containing a `main.txt` is considered as a stylesheet. Each stylesheet `x` has a main entrypoint (`x/main.txt`) which composes the output of the different XQueries and different outputs of the XML documents. 

* `acm`: A possible configuration for ACM Conferences.
* `ieee_jr`: Main configuration for the IEEE Journal.
* `plaintext`: Converting the paper into human-readable plaintext.

These options must be specified as a `--style` parameter. More styles will come in the following releases.
