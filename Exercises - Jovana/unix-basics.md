# Unix and Bash Basics: Interactive Guide

## 1. Introduction to Unix System Architecture

### The Restaurant Analogy of Unix Layers

Unix can be understood as a multi-layered system, similar to a sophisticated restaurant:

1. **User Interface Layer** (Customer)
   - You interact directly with the system
   - Submit requests through terminal or GUI

2. **Shell Layer** (Waiter)
   - Interprets and translates your commands
   - Prepares commands for system execution

3. **System Call Interface** (Restaurant Manager)
   - Validates and manages resource requests
   - Ensures security and proper access

4. **Kernel Layer** (Kitchen)
   - Core system management
   - Schedules processes
   - Manages memory and resources

5. **Hardware Interaction Layer** (Kitchen Workers)
   - Executes low-level hardware instructions

## 2. Basic System Information Commands

Let's explore some fundamental Unix commands to get system information:

```bash
# Display hostname
hostname

# Show current user and login information
who am i

# Display current date and time
date

# Display current month's calendar
cal
```

## 3. File and Directory Operations

Navigating and managing files and directories:

```bash
# Print current working directory
pwd

# List directory contents
ls

# Detailed list with human-readable sizes
ls -lh

# Create a new directory
mkdir unix_practice
ls

# Change directory
cd unix_practice
pwd
```

## 4. File Manipulation

Creating, copying, and managing files:

```bash
# Create empty files
touch file1.txt file2.txt file3.txt
ls

# Copy a file
cp file1.txt file4.txt
ls

# Move/Rename a file
mv file2.txt renamed_file.txt
ls

# Remove a file
rm file3.txt
ls
```

## 5. Process Management

Working with system processes:

```bash
# List current processes
ps

# Detailed process list
ps aux
```

## 6. Text Processing

Basic text file manipulation:

```bash
# Add some content to a file
echo "Hello, Unix!" > file1.txt
echo "Welcome to Bash scripting." >> file1.txt

# View file contents
cat file1.txt

# Search within files
grep "Unix" file1.txt
```

## 7. Permissions

Understanding file permissions:

```bash
# Check file permissions
ls -l

# Change file permissions
chmod 755 file1.txt
ls -l file1.txt
```

