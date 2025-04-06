#!/bin/bash

show_usage(){
	echo "Usage $0 <PROTOCOL> <DATE>"
	exit 1
}






case "$#" in
	0) 
		echo "Please specify at least one argument"
		show_usage
		;;
	1)

