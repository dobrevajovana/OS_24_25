# Text Processing Exercises: From Basic to Advanced

## Sample Files (Same as previous examples)

## Level 1: Basic Exercises

### Exercise 1.1: Simple Pattern Matching
Using `webserver.log`:
1. Find all lines containing "GET" requests
2. Count how many POST requests there are
3. List all lines containing status code 200
4. Find requests made by 'mary'

Solutions:
```bash
# 1. Find GET requests
grep "GET" webserver.log

# 2. Count POST requests
grep -c "POST" webserver.log

# 3. List status 200 requests
grep "HTTP/1.1\" 200" webserver.log

# 4. Find Mary's requests
grep "mary" webserver.log
```

### Exercise 1.2: Basic awk Field Processing
Using `employees.csv`:
1. Print only the Name and Department columns
2. Show all IT department employees
3. List employees with salary above 70000
4. Display each employee's join year

Solutions:
```bash
# 1. Print Name and Department
awk -F',' 'NR>1 {print $2, $3}' employees.csv

# 2. Show IT employees
awk -F',' '$3=="IT" {print $2}' employees.csv

# 3. List high salaries
awk -F',' '$4>70000 {print $2, $4}' employees.csv

# 4. Display join years
awk -F',' 'NR>1 {split($5,date,"-"); print $2, date[1]}' employees.csv
```

### Exercise 1.3: Simple System Analysis
Using `system_status.txt`:
1. Find all CPU usage lines
2. Show available memory lines
3. List network interface status
4. Count number of processes

Solutions:
```bash
# 1. Find CPU usage
grep "CPU Usage:" system_status.txt

# 2. Show memory
grep "Memory Available:" system_status.txt

# 3. List network status
grep "Network Interface:" system_status.txt

# 4. Count processes
grep -c "Process:" system_status.txt
```

## Level 2: Intermediate Exercises

### Exercise 2.1: Advanced Pattern Matching
Using `webserver.log`:
1. Extract all unique IP addresses
2. Find requests with response time > 0.3 seconds
3. Count requests per user
4. List all unique HTTP methods (GET/POST)

Solutions:
```bash
# 1. Unique IPs
grep -oE '[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}' webserver.log | sort -u

# 2. Slow requests
awk '$NF > 0.3 {print $1, $7, $NF}' webserver.log

# 3. Requests per user
awk -F'[][]' '{print $2}' webserver.log | awk '{print $1}' | sort | uniq -c

# 4. HTTP methods
awk '{print $6}' webserver.log | tr -d '"' | sort -u
```

### Exercise 2.2: Data Analysis
Using `employees.csv`:
1. Calculate average salary per department
2. Find the most recent hire in each department
3. Count employees per department
4. Find salary range (min/max) for each department

Solutions:
```bash
# 1. Average salary by department
awk -F',' 'NR>1 {
    sum[$3] += $4; count[$3]++
} 
END {
    for (dept in sum) 
        printf "%s: $%.2f\n", dept, sum[dept]/count[dept]
}' employees.csv

# 2. Most recent hire
awk -F',' 'NR>1 {
    if($5 > latest[$3] || !(latest[$3])) {
        latest[$3] = $5
        name[$3] = $2
    }
} 
END {
    for(dept in latest) 
        print dept, name[dept], latest[dept]
}' employees.csv

# 3. Department count
awk -F',' 'NR>1 {count[$3]++} 
END {
    for(dept in count) 
        print dept, count[dept]
}' employees.csv

# 4. Salary range
awk -F',' 'NR>1 {
    if(!min[$3] || $4 < min[$3]) min[$3] = $4
    if(!max[$3] || $4 > max[$3]) max[$3] = $4
} 
END {
    for(dept in min) 
        printf "%s: $%d - $%d\n", dept, min[dept], max[dept]
}' employees.csv
```

