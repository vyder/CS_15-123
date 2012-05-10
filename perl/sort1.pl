#!/usr/bin/perl -W
use warnings;
use strict;

my @ints = ( 9,1,7,3,6,4,5 ); 

print "ints un-sorted: @ints\n";
@ints = sort { $a <=> $b } @ints; 
print "ints sorted: @ints\n";


