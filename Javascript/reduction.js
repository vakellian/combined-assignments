let arr = [1, 2, 33, 4, 5]

console.log(arr.reduce(
    (previouslyReturned, currentElement) => {

        previouslyReturned.push(currentElement)

        for (let i = 0; i < previouslyReturned.length; i++) {

            for (let j = 0; j < previouslyReturned.length; j++) {

                if (previouslyReturned[j] < previouslyReturned[j + 1]) {
                    let temp = previouslyReturned[j];
                    previouslyReturned[j] = previouslyReturned[j + 1]
                    previouslyReturned[j + 1] = temp;
                }

            }

        }
        return previouslyReturned
    }, []
))





