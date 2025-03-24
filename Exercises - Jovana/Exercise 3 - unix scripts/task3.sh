#!/bin/bash

IFS=','
string_of_file=`cat $1`
touch tmp.txt
for i in $string_of_file
do
	echo $i >> tmp.txt
done
len=`cat tmp.txt | wc -l`

string_of_file=`cat tmp.txt`
for ((i=$len; i>0; i-=1))
do
	echo $string_of_file[$i]
done

