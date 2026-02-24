# Reflections Log

This document serves as a log of reflections on various topics, capturing insights, lessons learned, and personal growth. It is intended to help users track their thoughts and experiences over time.
[AI Effectiveness: Where did AI tools excel? Where did they struggle?]
- Gemini did an overall good job at handling class generation. It was stay consistent with naming conventions, formatting, and multiple file integration.
- However, it did struggle as soon as I added the human element of allowing the IDE to guide me to an incorrect solution of adding dependencies that ultimately caused issues with test classes.
[Code Quality Comparison: How does AI-generated code compare to manual coding?]
- The AI-generated code was generally well-structured and followed good coding practices. It was able to generate code that was functional and met the requirements specified in the prompts. 
- However, it lacked the ability to troubleshoot and resolve issues when it came ot how I was manipulating sections of code without telling Gemini, which is a fair expectation.
[Learning Experience: What did you learn about inheritance AND AI-assisted development?]
- Inheritance played an important role in the code of all the shapes as they all stemmed from the abstract class. 
- Knowing that these classes "played together" helped me to understand some background information about how the code was functioning.
- As for AI assisted development, I learned that AI can be a powerful tool for generating boilerplate code in bulk.
- Also, informing the AI of choice is integral for consistency and accuracy in the code generation process, but it also wasn't too difficult to have it assist me in the troubleshooting process.
- I also realized that if you need to make many manual changes to the code you could end up down a rabbit hole of explaining your code to AI when an issue arises that you cant seem to fix.
[Validation Process: How did you ensure the AI-generated code was correct?]
- I manually tested all the classes and methods to ensure they were working properly and giving a well formatted output.
- I also validated all the mathematical formulas for volume and surface area against multiple online resources to ensure they were correct. (In AI_INTERACTION_LOG.md)
[Future Applications: How will you use AI tools in future programming projects?]
- Attempt to give the AI all the information available about deadlines, requirements, and any other relevant information to ensure the best possible output.
- Use AI to generate boilerplate code and then manually review and test the code to ensure it meets the requirements and is free of errors.
- Use AI as a tool for troubleshooting and problem-solving, while being prepared to provide a thorough explanation of the issue and the code.
[General Reflection]
- I can see how the power of AI is changing the industry and will have a great impact on the future of computer science especially when it comes to some of the less nuanced parts of coding.
[Factory Implementation Reflection]
- I found the factory implementation to be a very interesting, and useful, design pattern that I had not previously been exposed to.
- The way that it handles the creation of objects seems like a superior way than individual constructors and I found that the name "Factory" was a very fitting name!
- The fact that it reduces some of the repetition of editing constructors one by one when post development changes are made is a huge plus.
- The implementation of the factory pattern into a driver class wasn't very difficult for the AI as it seemed to just replace the building object with the factory as opposed to calling constructors.