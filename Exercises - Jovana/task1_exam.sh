#!/bin/bash

usage () {
 if [ -z $1 ]
 	echo "Usage: $0 <RACE_TEAM>"
	exit 1 
  fi
}

usage $@

grep $1 files/race_results.tsv | awk '{counter[$3]+=$NF} END {for(year in counter) print year, counter[year]}' 
grep $1 files/race_results.tsv | awk '{if($NF > "0") print $7-$6, $1}' | sort -nr | head -1
grep $1 files/race_results.tsv | awk '{if($NF > "0") print $1;}' |  sort | uniq | wc -l
