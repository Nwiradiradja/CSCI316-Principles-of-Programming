//Nathaniel Wiradiradja
//Mashiur Rahman

#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>

void fillArrays(int rows, int cols,
                const std::vector < int > & data, int ** rowMaj, int ** colMaj) {
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) { //iterate over the rows and columns for row major
            int index = i * cols + j; //calculate linear indices for row major
            if (index < data.size()) { // Check if index is within bounds
                int val = data[index];
                rowMaj[i][j] = val;
            } else { // If index is out of bounds, fill with a default value (e.g., 0)
                rowMaj[i][j] = 0;
            }
        }
    }

    for (int j = 0; j < cols; ++j) {
        for (int i = 0; i < rows; ++i) { //Iterate over rows and columns for column major
            int index = j * rows + i; //calculate linear indices for column major
            if (index < data.size()) { // Check if index is within bounds
                int val = data[index];
                colMaj[j][i] = val;
            } else { // If index is out of bounds, fill with a default value (e.g., 0)
                colMaj[j][i] = 0;
            }
        }
    }
}

void printArray(int rows, int cols, int ** arr, bool isColMajor = false, std::ostream & outStream = std::cout, std::ofstream * outFile = nullptr) {
    if (!isColMajor) { //Uses Boolean to ensure that this is row major that it checks
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                outStream << arr[i][j] << " "; //Uses arr[i][j] because that is how you access indices for a row major form
                if (outFile != nullptr) //while output file isnt null
                    *
                            outFile << arr[i][j] << " "; //Display the output file
            }
            outStream << "\n";
            if (outFile != nullptr)
                *
                        outFile << "\n";
        }
    } else { //else this will check the column major
        for (int i = 0; i < cols; ++i) { //loop through the columns and rows
            for (int j = 0; j < rows; ++j) {
                outStream << arr[j][i] << " "; //Uses arr[j][i] because that is how you access indices in column major
                if (outFile != nullptr) //While the output file isnt null
                    *
                            outFile << arr[j][i] << " "; //Display the output file
            }
            outStream << "\n";
            if (outFile != nullptr)
                *
                        outFile << "\n";
        }
    }
}

int main() {
    std::ifstream inputFile("C:\\Users\\Nate\\CLionProjects\\CSCI316\\input.txt");
    std::string line;
    std::ofstream outputFile("C:\\Users\\Nate\\CLionProjects\\CSCI316\\ArrayOutput.txt");
    while (getline(inputFile, line)) {
        std::vector < int > data;
        int rows, cols;
        std::stringstream ss(line);
        ss >> rows >> cols;
        int num;
        while (ss >> num) {
            data.push_back(num);
        }

        outputFile << "Original Data: " << rows << " " << cols << " ";
        for (const auto & value: data) {
            outputFile << value << " "; //This saves the data in the output txt file
        }
        outputFile << std::endl;

        std::cout << "Original Data: " << rows << " " << cols << " ";
        for (const auto & value: data) {
            std::cout << value << " ";// This prints the orignal data in the console
        }
        std::cout << std::endl;

        // Calculate the actual number of rows based on the size of the data vector
        int actualRows = data.size() / cols;
        if (data.size() % cols != 0) { // If there's not enough data for a full row
            actualRows += 1; // Add an extra row
        }

        int ** rowMaj = new int * [actualRows];
        int ** colMaj = new int * [cols];
        for (int i = 0; i < actualRows; ++i) {
            rowMaj[i] = new int[cols];
        }
        for (int i = 0; i < cols; ++i) {
            colMaj[i] = new int[actualRows];
        }

        fillArrays(actualRows, cols, data, rowMaj, colMaj);

        outputFile << "Row-Major:" << std::endl;
        printArray(actualRows, cols, rowMaj, false, outputFile);
        outputFile << std::endl; //Saves and displays the information in an output file

        std::cout << "Row-Major:" << std::endl;
        printArray(actualRows, cols, rowMaj, false);
        std::cout << std::endl; //Saves and displays this in the console

        outputFile << "Column-Major:" << std::endl;
        printArray(cols, actualRows, colMaj, true, outputFile);
        outputFile << std::endl; //Saves and displays the information in an output file

        std::cout << "Column-Major:" << std::endl;
        printArray(cols, actualRows, colMaj, true);
        std::cout << std::endl; //Displays the information in the console

        for (int i = 0; i < cols; ++i) { //loop through the columns
            delete[] colMaj[i]; //Delete the column major
        }
        delete[] rowMaj; //Delete row major
        delete[] colMaj; //Delete column major
    }
    return 0;
}

//std::ifstream inputFile("C:\\Users\\Nate\\CLionProjects\\CSCI316\\input.txt");
//    std::string line;
//    std::ofstream outputFile("C:\\Users\\Nate\\CLionProjects\\CSCI316\\ArrayOutput.txt");