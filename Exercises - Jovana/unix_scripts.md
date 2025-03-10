 # Bash Scripting Tutorial for Second-Year Students

## Introduction to Shell and Bash

The shell is a command-line interface that allows users to interact with the operating system. Bash (Bourne Again SHell) is one of the most popular Unix shells, the default shell in most Linux distributions and macOS (until Catalina).

Bash scripting enables you to:
- Automate repetitive tasks
- Create custom commands
- Process files and data
- Schedule tasks with cron jobs
- Interact with the operating system programmatically

## 1. Creating Your First Bash Script

Let's start with a simple "Hello, World!" script:

```bash
#!/bin/bash
# My first bash script
echo "Hello, World!"
```

The components of this script:
- `#!/bin/bash` - Shebang line that tells the system to use the Bash interpreter
- `#` - Comment line (ignored by the interpreter)
- `echo` - Command to display text to the terminal

### How to Run the Script:

1. Create the file with a text editor:
   ```
   nano hello.sh
   ```

2. Make the script executable:
   ```
   chmod +x hello.sh
   ```

3. Run the script:
   ```
   ./hello.sh
   ```

## 2. Variables in Bash

Variables store data that can be referenced and manipulated in a script.

```bash
#!/bin/bash

# Variable assignment (no spaces around '=')
name="Student"
course="Bash Scripting"
year=2

# Accessing variables using $
echo "Hello, $name!"
echo "Welcome to $course"
echo "You are in year $year"

# Command substitution
current_date=$(date)
echo "Today is: $current_date"

# Arithmetic operations
next_year=$((year + 1))
echo "Next year you will be in year $next_year"
```

Key points:
- Variable names are case-sensitive
- No spaces around the equals sign in assignments
- Use `$` to access variable values
- Use `$(command)` for command substitution
- Use `$((expression))` for arithmetic

## 3. Input and Output

```bash
#!/bin/bash

# Read user input
echo "What is your name?"
read username

echo "What is your student ID?"
read student_id

# Output with formatting
echo "---------------------"
echo "User details:"
echo "Name: $username"
echo "ID: $student_id"
echo "---------------------"

# Writing to a file
echo "$username ($student_id) logged in on $(date)" >> user_logs.txt

# Reading from a file
echo "Previous logins:"
cat user_logs.txt
```

Key commands:
- `read` - Takes user input
- `echo` - Displays output
- `>>` - Appends to a file
- `>` - Overwrites a file
- `cat` - Displays file contents

## 4. Conditional Statements

Bash uses `if`, `elif`, and `else` for conditional execution.

```bash
#!/bin/bash

echo "Enter your exam score (0-100):"
read score

if [ $score -ge 90 ]; then
    echo "Grade: A"
elif [ $score -ge 80 ]; then
    echo "Grade: B"
elif [ $score -ge 70 ]; then
    echo "Grade: C"
elif [ $score -ge 60 ]; then
    echo "Grade: D"
else
    echo "Grade: F"
fi

# File test conditions
filename="data.txt"
if [ -e "$filename" ]; then
    echo "$filename exists"
    
    if [ -r "$filename" ]; then
        echo "$filename is readable"
    fi
    
    if [ -w "$filename" ]; then
        echo "$filename is writable"
    fi
else
    echo "$filename does not exist"
    touch "$filename"
    echo "Created $filename"
fi
```

Key comparison operators:
- `-eq` - Equal to
- `-ne` - Not equal to
- `-gt` - Greater than
- `-lt` - Less than
- `-ge` - Greater than or equal to
- `-le` - Less than or equal to

File test operators:
- `-e` - File exists
- `-f` - Regular file exists
- `-d` - Directory exists
- `-r` - File is readable
- `-w` - File is writable
- `-x` - File is executable

## 5. Loops

Bash provides three main types of loops:

### For Loops

```bash
#!/bin/bash

# Basic for loop
echo "Counting from 1 to 5:"
for i in 1 2 3 4 5
do
    echo "Number: $i"
done

# For loop with range
echo "Counting from 1 to 10:"
for i in {1..10}
do
    echo "Number: $i"
done

# For loop with step value
echo "Even numbers from 2 to 10:"
for i in {2..10..2}
do
    echo "Number: $i"
done

# For loop through files
echo "Text files in current directory:"
for file in *.txt
do
    echo "File: $file"
done
```

### While Loops

```bash
#!/bin/bash

# Basic while loop
count=1
echo "While loop counting to 5:"
while [ $count -le 5 ]
do
    echo "Count: $count"
    count=$((count + 1))
done

# Reading a file line by line
echo "Reading data.txt line by line:"
while read line
do
    echo "Line: $line"
done < data.txt
```

### Until Loops

```bash
#!/bin/bash

# Until loop (runs until condition becomes true)
counter=5
echo "Countdown:"
until [ $counter -lt 1 ]
do
    echo "$counter..."
    counter=$((counter - 1))
    sleep 1
done
echo "Blast off!"
```

## 6. Functions

Functions allow you to group commands and reuse code.

```bash
#!/bin/bash

# Define a function
greet() {
    echo "Hello, $1!"
    echo "Today is $(date)"
}

# Function with return value
calculate_sum() {
    local num1=$1
    local num2=$2
    local sum=$((num1 + num2))
    echo $sum
}

# Call the function with parameter
echo "Calling greet function:"
greet "Student"

# Call function and capture return value
result=$(calculate_sum 5 10)
echo "Sum of 5 and 10 is: $result"

# Function with local variables
process_file() {
    local filename=$1
    local count=0
    
    if [ ! -f "$filename" ]; then
        echo "Error: $filename does not exist"
        return 1
    fi
    
    while read line
    do
        count=$((count + 1))
    done < "$filename"
    
    echo "$filename has $count lines"
    return 0
}

# Call the function with a parameter
process_file "data.txt"
```

Key points:
- Functions must be defined before they are called
- Use `local` to declare variables with function scope
- Functions can return values using `echo` or return status codes (0-255)

## 7. Arrays

Bash supports indexed and associative arrays.

```bash
#!/bin/bash

# Indexed arrays (zero-based)
courses=("Programming" "Networking" "Databases" "Operating Systems")

# Accessing elements
echo "First course: ${courses[0]}"
echo "Third course: ${courses[2]}"

# All elements
echo "All courses: ${courses[@]}"

# Number of elements
echo "Number of courses: ${#courses[@]}"

# Adding an element
courses+=("Web Development")
echo "Updated courses: ${courses[@]}"

# Associative arrays (requires Bash 4+)
declare -A student_grades
student_grades["John"]=85
student_grades["Mary"]=92
student_grades["Peter"]=78

# Accessing associative array
echo "Mary's grade: ${student_grades["Mary"]}"

# All keys
echo "All students: ${!student_grades[@]}"

# Iterating through an associative array
echo "Student grades:"
for student in "${!student_grades[@]}"
do
    echo "$student: ${student_grades[$student]}"
done
```

## 8. Error Handling and Debugging

```bash
#!/bin/bash

# Exit on error
set -e

# Enable debugging (shows each command before execution)
# set -x

# Custom error function
error_exit() {
    echo "ERROR: $1" >&2
    exit 1
}

# Check number of arguments
if [ $# -lt 1 ]; then
    error_exit "Usage: $0 <filename>"
fi

# Check if file exists
if [ ! -f "$1" ]; then
    error_exit "File $1 not found"
fi

echo "Processing $1..."
# Continue with the script
echo "Done"
```

Key debugging techniques:
- `set -e` - Exit immediately if a command fails
- `set -x` - Print each command before execution

