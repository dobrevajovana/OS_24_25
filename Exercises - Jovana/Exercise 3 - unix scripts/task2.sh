#!bin/bash

#
select file in `ls` 'Exit Program' 
	
do
	if [ $file = "Exit Program" ]; then
		echo "Exit"
		exit 1
	fi

	if [ -f $file ];
		then 
			cat $file
	
	else
		echo "Not a regular file"
		exit 1
	fi

	
	echo $file
done
