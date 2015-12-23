# diceware-generator

A Clojure program to generate Diceware passwords.

### What is Diceware?

[Diceware](http://world.std.com/~reinhold/diceware.html) is a method of 
generating passwords that is as random as possible, which involves using 
physical dice to generate numbers which are then matched to corresponding words. 
The added randomness is intended to correct detectable patterns in the 
passwords we normally generate for ourselves (preferred song lyrics, pet names, 
etc) which can be used to guess those passwords.

### Why not just build a website?

Because a malicious party could hack the lines of communication between you and
the server, exposing any newly generated password to someone other than you.

### Is this program the preferred method?

No. Using the original "pad and pen" method is the preferred option, given that 
it's "truly" random and doesn't use an electronic method that could potentially
expose passwords to a malicious party. By using this program, you benefit from
convenience and lose a certain degree of security. However, if the pad and pen
method deters you from using Diceware at all, then this program may be something
of an improvement in your password security.

### How do I know this program is secure?

The code for this project [rests in single file](https://github.com/dkoloditch/diceware-generator/blob/master/src/diceware_generator/core.clj) and is intentionally kept as simple as possible so 
any discerning party (you) can scan it for flaws.

### How does it work?

The code generates a random number which is then matched to a word/symbol in 
the wordlist file. This technique is repeated for the requested number of words 
and the final results are spit out.

### Prerequisites
1. Install Java
2. Install [Clojure](https://en.wikibooks.org/wiki/Clojure_Programming/Getting_Started#Installation)
3. Install [Leiningen](http://leiningen.org/)

### How to Use
1. Clone this repo: ```git clone git@github.com:dkoloditch/diceware-generator.git```
2. Navigate to the directory: ```cd diceware-generator```
2. Run the program: ```lein run```