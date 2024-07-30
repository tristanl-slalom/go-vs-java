package main

import (
	"bufio"
	"fmt"
	"os"
	"time"
)

func main() {
	fmt.Println("Go IO Performance Test")
	filename := "testfile-go.txt"
	content := []byte("This is a line of text.\n")

	start := time.Now()

	// Create the file
	file, err := os.Create(filename)
	if err != nil {
		fmt.Println("Error creating file:", err)
		return
	}

	// Buffered writer is much more time-efficient!
	w := bufio.NewWriter(file)

	for i := 0; i < 1000000; i++ {
		_, err := w.Write(content)
		if err != nil {
			fmt.Println("Error writing to file:", err)
			return
		}
	}
	file.Close()

	writeDuration := time.Since(start)
	fmt.Printf("Write duration: %v\n", writeDuration)

	start = time.Now()

	// Read from file
	_, err = os.ReadFile(filename)
	if err != nil {
		fmt.Println("Error reading file:", err)
		return
	}

	readDuration := time.Since(start)
	fmt.Printf("Read duration: %v\n", readDuration)
}
