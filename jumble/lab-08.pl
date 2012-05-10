#!/usr/local/bin/perl -W
use warnings;
use strict;
use Getopt::Long;

my $url;
my $file;

GetOptions("file=s" => $file, "url=s" => $url);

my @dictionary = split '', get( );
my %hashtable;

foreach $word in @dictionary
{
	$key = join '', sort split '', $word;
	$hashtable{$key} = $word;
}

foreach $word in @ARGV
{
	print "{$word}: " . $hashtable{$key} . "\n";
}
