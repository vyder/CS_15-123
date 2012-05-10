#!/usr/bin/perl

# use operator gives us access to the functions in the Getopt module.
# ::Long means options are preceeded with a double dash --
use Getopt::Long;   

my $intArg;
my $stringArg;

# the => causes the int arg and the string arg to be stored in $intArg and $strArg respectively
	
GetOptions("int=i" => \$intArg,	# the n=i means we expect a literal "--n " followed by a valid integer. (i) 
           "str=s" => \$strArg);  # the t=s means we expect a literal "--t " followed by a string. (s) 

print "you entered this int arg: $intArg and this string arg: $strArg\n";
