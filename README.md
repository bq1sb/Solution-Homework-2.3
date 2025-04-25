# Solution-Homework-2.3
In the first task, I implemented a system for watching TV series with different iteration modes: regular order, reverse and random (shuffle). I also made a bind mode that allows you to watch the entire series at once without switching between seasons.
Each season stores episodes in a List, but in real life it can be a LinkedList or even a file, and then direct access to the list will be inconvenient. Therefore, I decided to hide the storage method using the Iterator pattern.

Why Iterator is better than just a List<Episode>

It's easy to add other passageways.
For example, I added a ReverseSeasonIterator and a ShuffleSeasonIterator. If we were just returning a List, we would have to copy and change the list manually. With an iterator, it's all encapsulated.

You can create complex iterators like BingeIterator.
It runs through all the seasons in a row — and it's all through a single interface. The client does not need to write nested loops.


In the second task, I implemented an airport management system using the Mediator pattern. Instead of planes communicating directly with each other (which would lead to chaos), all coordination goes through ControlTower, a central intermediary.

I have three types of aircraft: Passenger Plane, CargoPlane, and Helicopter. They all send requests to the tower and receive responses only through it. The tower manages the queues for landing and take-off and grants permissions in FIFO order. If someone gives the "MAYDAY" signal, then he gets priority.

Why is Mediator Better than Direct Communication

It's easier to add new rules and logic.
For example, I implemented emergency situations — if a plane says "MAYDAY", the tower clears the lane, suspends others and immediately gives permission. It would be difficult to do this without Mediator.
