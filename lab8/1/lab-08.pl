#!/usr/local/bin/perl -W
use warnings;
use strict;
use LWP::Simple;
use Getopt::Long;

my $wordString;
my $file = '';
my $url = '';

GetOptions("url=s" => \$url, "file=s" => \$file);

if( $url ne '' )
{
	$wordString = get( $url );
}
elsif( $file ne '' )
{
	open(INFILE, "<$file");
	while(<INFILE>)
	{
		$wordString .= $_;
	}
	close( INFILE );
}
else
{
	$wordString="@ARGV";
}

my @jumbledWords = split '\n', $wordString;
@jumbledWords = split ' ', $wordString;
my @dictionary = split '\n', get( "http://www.cs.cmu.edu/~thoffman/S09-15123/lab-8/dictionary.txt" );
	
my %hashtable;

my $word;
my $key; 
foreach $word (@dictionary)
{
	$key = join '', sort split '', $word;
	$hashtable{$key} .= " $word";
}

foreach $word (@jumbledWords)
{
	$key = join '', sort split '', $word;
	print "${word}: $hashtable{$key}\n";
}