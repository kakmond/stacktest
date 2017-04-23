# Stack Test
Test | Result of Stack Type 0 | Result of Stack Type 1
--------|-----------|-------:
__testPop__ | __Correct__ | __Failure:__ The Stack invalid size.
__testPeek__ | __Correct__ | __Failure:__ The Stack invalid size.
__testSize__ | __Correct__ | __Failure:__ The Stack invalid size.
__newStackIsEmpty__ | __Correct__ | __Correct__
__testCapacity__ | __Correct__ | __Correct__
__testNullParameter__ | __Correct__ | __ERROR :__ Should throw InvalidArgumentException.
__testOverflow__ | __ERROR :__ Should throw IllegalStateException. | __ERROR :__ Should throw IllegalStateException.
__testIsFull__ | __Correct__ | __Failure:__ The Stack must be full.
__testCapacityZero__ | __Correct__ | __Failure:__ Zero capacity must be full.
__testPopEmptyStack__ | __Correct__ | __Correct__
