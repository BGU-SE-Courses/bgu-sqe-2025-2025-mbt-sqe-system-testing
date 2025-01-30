#!/bin/bash

# Check if JAVA_HOME is set
if [ -z "$JAVA_HOME" ]; then
    echo "JAVA_HOME is not set. Checking for Java installation..."
    
    # Try to find Java using `/usr/libexec/java_home`
    JAVA_HOME=$(/usr/libexec/java_home 2>/dev/null)
    
    if [ -z "$JAVA_HOME" ]; then
        echo "Java 11 or higher is required but not found. Please install Java (https://www.oracle.com/java/technologies/downloads)."
        exit 1
    fi
fi

# Check if ChromeDriver is installed
if ! command -v chromedriver &>/dev/null; then
    echo "ChromeDriver is not installed or not found in PATH. Please install it from https://sites.google.com/chromium.org/driver/downloads"
    exit 1
fi

# Set ChromeDriver in PATH (if not already set)
export PATH=$PATH:/usr/local/bin

# Run Selenium Server
"$JAVA_HOME/bin/java" -jar selenium-server-4.18.1.jar standalone
