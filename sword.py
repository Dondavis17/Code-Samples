#declaration of list and vai

n = 69
s = [] in range(1, n+1)
j = 1

def sword(j, s):

	#base case return answer
	if len(s) == 1:
		print s
		return s


	# kills next person in line and passes sword to 
	#next in line also checks for list length so as
	#not to go out of bounds
	if len(s) > 1:
		s.pop(j)
		j = (j + 1) % len(s)	

	#recursive call to itself
	sword(j, s)

#initializes the function to start the program
sword(j,s)