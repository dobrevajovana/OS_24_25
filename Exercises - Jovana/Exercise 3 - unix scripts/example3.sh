#!/bin/bash

counter=0

while [ $counter -lt 5 ]
do
	echo "Number $counter"
	counter=$((counter + 1))

done

while read line
do
	echo $line
done < $1

until [ $counter -lt 1 ]
do
	echo "$counter"
	counter=$((counter - 1))
done
