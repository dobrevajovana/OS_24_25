#!/bin/bash

set -e

#add condition for arg
if [ $# -lt 1 ]; then
	echo "no added arguments, please try again"
	exit 1
fi

if [ -e $1 ]; then
	echo "file exists"
fi

array="
1
2
3
45
5"
for i in $array
do
	echo "$i"
done

