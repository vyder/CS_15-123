#!/usr/bin/perl -W
use warnings;
use strict;

my %hshtbl;

$hshtbl{"do"} = " ...a deer, a female deer... "; # stores BOTH the key nad the value into the hash
$hshtbl{"re"} = " ...a golden drop of sun... "; # note the $ sign to the left of the hash variable
$hshtbl{"me"} = " ...a name I call myself... "; # thats because hshtbl{key} produces the associated value which in this case is a scalar
	my $key; # just a scalar to hold a key 
	print"\nKEY\t    \tVALUE\n";
foreach $key ( keys %hshtbl)  # <b>keys</a> is the operator the produces an array of all the keys in the hash
{
	print "$key\t-->\t$hshtbl{$key}\n"; # hash{key} produces the associated value
}

# We can generate an array of keys or values values using the <b>keys</b> or <b>values</b> operator

my @keysArr = keys %hshtbl;
my @valsArr = values %hshtbl;
	
print "keysArr: @keysArr\n";
print "valsArr: @valsArr\n";
	
# if we wish to delete a pair from the hash we use the <b.delete</b> operator
	
delete $hshtbl{"re"};  # removes BOTH "re" and its associated value "a golden drop of sun" from the hash
	
print "\nAfter deleting \"re\"\n";
	
print"\nKEY\t    \tVALUE\n";
foreach $key ( keys %hshtbl)  # <b>keys</a> is the operator the produces an array of all the keys in the hash
{
	print "$key\t-->\t$hshtbl{$key}\n"; # hash{key} produces the associated value
}
	
# just to illustrate that those 2 arrays we extracted are not shallow extractions
	
print "\nthe two arrays should not be affected by a deletion to the hash\n\n";
	
print "keysArr: @keysArr\n";
print "valsArr: @valsArr\n";