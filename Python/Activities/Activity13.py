# Function to calculate sum
def calculateSum(numbers):
    sum = 0
    for number in numbers:
        sum+=number
    return sum

# List of numbers
numList = [10, 40, 60, 90]

	
# Call the sum() function with numList as argument
res = calculateSum(numList)

# Print result
print("The sum of all the elements is: " + str(res))