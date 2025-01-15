# List of URLs to download
urls=("https://storage.googleapis.com/chrome-for-testing-public/131.0.6778.264/win64/chrome-win64.zip")

# Loop through each URL and process the file
for url in "${urls[@]}"; do
    filename=$(basename "$url")
    echo "Downloading $url..."
    curl -o "$filename" "$url"

    if [[ $? -ne 0 ]]; then
        echo "Failed to download $url"
        continue
    fi
    echo "Successfully downloaded $url."

    # Extract the file if it's a .zip
    if [[ "$filename" == *.zip ]]; then
        echo "Extracting $filename..."
        unzip -o "$filename" -d ./

        if [[ $? -ne 0 ]]; then
            echo "Failed to extract $filename"
        else
            echo "Successfully extracted $filename"
        fi
    else
        echo "Skipping extraction for $filename (not a .zip file)."
    fi

    # Delete the downloaded file
    echo "Deleting $filename..."
    rm -f "$filename"

    if [[ $? -ne 0 ]]; then
        echo "Failed to delete $filename"
    else
        echo "$filename deleted successfully."
    fi
done

echo "All downloads, extractions, and cleanups complete!"