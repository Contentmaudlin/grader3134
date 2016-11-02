prev () {
    # default to current directory if no previous
    local prevdir="./"
    local cwd=${PWD##*/}
    if [[ -z $cwd ]]; then
        # $PWD must be /
        echo 'No previous directory.' >&2
        return 1
    fi
    for x in ../*/; do
        if [[ ${x#../} == ${cwd}/ ]]; then
            # found cwd
            if [[ $prevdir == ./ ]]; then
                echo 'No previous directory.' >&2
                return 1
            fi
            cd "$prevdir"
            return
        fi
        if [[ -d $x ]]; then
            prevdir=$x
        fi
    done
    # Should never get here.
    echo 'Directory not changed.' >&2
    return 1
}

next () {
    local foundcwd=
    local cwd=${PWD##*/}
    if [[ -z $cwd ]]; then
        # $PWD must be /
        echo 'No next directory.' >&2
        return 1
    fi
    for x in ../*/; do
        if [[ -n $foundcwd ]]; then
            if [[ -d $x ]]; then
                cd "$x"
                return
            fi
        elif [[ ${x#../} == ${cwd}/ ]]; then
            foundcwd=1
        fi
    done
    #echo 'No next directory.' >&2
    return 1
}

#main functionality is here
cd testfiles
testcount=$(ls | wc -l)
cd .. 
cd student_solutions
dircount=$(ls | wc -l)
echo "Number of submissions: $dircount"

cd */
COUNTER=0
while [ $COUNTER -lt $dircount ]; do
	echo "Testing: ${PWD##*/}"
	printf "RUNNING $((testcount - 1)) TESTS ON ${PWD##*/}\n\n" > results.txt
	javac Problem2.java > /dev/null 2>&1
	fileexists=$(ls | grep "Problem2.class")
	if [[ -z "$fileexists" ]]; then
		echo "Student file doesn't exist / doesn't compile / wrong name" >> results.txt
		echo ":(   Couldn't test for ${PWD##*/}"
	else
		COUNTER2=1
		while [ $COUNTER2 -lt ${testcount} ]; do
			echo "$TESTING test${COUNTER2}.txt" >> results.txt
			echo "***********" >> results.txt
			java Problem2 "../../testfiles/test${COUNTER2}.txt" >> results.txt 2>&1
			echo " " >> results.txt
			let COUNTER2=COUNTER2+1
		done
	fi
	next
	let COUNTER=COUNTER+1
done
cd ../../
