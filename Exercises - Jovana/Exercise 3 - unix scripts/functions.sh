#!/bin/bash

hey()
{
echo "hello $1"
}
sum=10
echo "sum from main: $sum"
sum()
{
local sum=$(($1 + $2))
echo "sum from function: $sum"
}

hey "jovana"
sum 1 3
echo "sum from main: $sum"


