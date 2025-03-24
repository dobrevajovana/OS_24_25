
#!/bin/bash

if [ $# -lt 1 ]; then
	echo "not added arg"
	exit 1
fi

if [ -f $1 ]; then
	echo "its not a directory"
	exit 1
fi

for file in `ls $1 | grep ".txt"`
do
	memories=`grep "Memory Available" $1/$file | awk '{print $NF}' | sed 's/GB//'`
	sum=0
	counter=0
	for i in $memories
	do
		sum=$((sum + i))
		counter=$((counter + 1))
	done
	echo "File: $file"
	echo "Avg: $sum/$counter"
done


