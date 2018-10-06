//function to repeat a string n number of times
String.prototype.repeatify = function (number) {
    var string = "";
    for (var i = 0; i < number; i++) {
        string = string + this;
    }
    return string;
}

//function to remove consecutive repeating characters in a string
function removeConsecutiveCharacters(inputString) {
    for (var i = 0; i < inputString.length - 2; i++) {
        var currentConsecutiveCharacterPosition = i;
        var stringToBeReplaced = inputString.charAt(i);
        //find substring containing consecutive repeating characters
        while (inputString.charAt(currentConsecutiveCharacterPosition) == inputString.charAt(currentConsecutiveCharacterPosition + 1)) {
            stringToBeReplaced += inputString.charAt(currentConsecutiveCharacterPosition);
            currentConsecutiveCharacterPosition++;
        }
        if (currentConsecutiveCharacterPosition > i) {
            //removes consecutive repeating character substring if exists
            inputString = inputString.replace(stringToBeReplaced, "");
            i--;
        }
    }
    return inputString;
}

