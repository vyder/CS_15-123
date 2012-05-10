#!/usr/bin/perl -W
use warnings;
use strict;

use Getopt::Long;
use LWP::Simple;

my $n = 15;
my $dir = 'default';
my $searchurl = '';
my $sourcecode = '';
my $page = 1;
my $morepages = 1;
my $nextpage = 0;
my $count = 0;
my $filename = '';

GetOptions ('dir=s' => \$dir, 'n=s' => \$n);

if (-d "$dir") 
{
print "There is a directory named $dir";
die();
}
else 
{
mkdir "$dir";
chdir "$dir";
}

$searchurl = "http://www.flickr.com/search/?q="."@ARGV";
$sourcecode = get($searchurl);

while($morepages == 1 && $count < $n)
{
	$sourcecode = join '', split '\n', $sourcecode; 
	
	while($count < $n && $sourcecode =~ /<td class="DetailPic">(.*?)<img src="(.*?)"(.*?)<\/td>/g)
	{
		$filename = join '_', split ' ', "@ARGV";
		my $temp = $count + 1;
		$filename .= "_$temp.jpg";
		
		my @words = split(/\//, $2);
		my $oldname = "$words[-1]";
		
		`wget -nd -q -m $2`;
		`mv $oldname $filename`;
		$count++;
	}	
	
	
	$nextpage = $page + 1;
	my $nextpageurl = $searchurl."&page=".$nextpage;
	my $nextpagecheck = "page=".$nextpage;
	if($sourcecode =~ /$nextpagecheck/ )
	{
		$morepages = 1;
		$sourcecode = get($nextpageurl);
	}
	else
	{
		$morepages = 0;
	}
	$page = $page + 1;
}
