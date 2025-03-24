#!/bin/bash

tolower()
{
	echo $@ | tr '[A-Z]' '[a-z]'
	
}

tolower $*
