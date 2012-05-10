#!/usr/bin/perl -W
use warnings;
use strict;

my $piVal = 3.14159;
my $radius = 1.5;
my $area = $piVal*$radius*$radius;

print "area = $area\n";

print "Pres RETURN to exit: ";
my $data = <STDIN>;
