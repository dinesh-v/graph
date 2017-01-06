## Synopsis

Graph implementation in Java 8 

## Code Example

Initialize an undirected graph and add edges.

    Graph<String> graph = new Graph<String>(false);
    graph.addEdge("A", "B", 2);
    graph.addEdge("A", "C", 12);
    graph.addEdge("A", "D", 7);
    graph.addEdge("C", "B", 1);
    graph.addEdge("B", "L", 4);

Print the graph in adjacency list format.
    
    System.out.println(graph);
    
Find shortest path using Dijkstra's algorithm

    Dijkstra<String> dijkstra = new Dijkstra<String>(graph, "A");
    dijkstra.findShortestPath();

## Implementation

 - [x] [Depth First Traversal](https://www.youtube.com/watch?v=iaBEKo5sM7w)
 - [x] [Breadth First Traversal](https://www.youtube.com/watch?v=QRq6p9s8NVg)
 - [x] [Dijkstra's algorithm](https://www.youtube.com/watch?v=pVfj6mxhdMw&t=46s)

## Installation

Provide code examples and explanations of how to get the project.

## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests
Test cases cover the following

 - [x] Depth First Traversal
 - [x] Breadth First Traversal
 - [x] Dijkstra's algorithm
~~~
    mvn test
~~~
# __Example__ # : Graph in Adjacency list

    A : [( B, 2 ), ( C, 12 ), ( D, 7 )]
    B : [( A, 2 ), ( C, 1 ), ( L, 4 )]
    C : [( A, 12 ), ( B, 1 ), ( D, 1 )]
    D : [( A, 7 ), ( C, 1 ), ( F, 1 )]
    F : [( D, 1 ), ( W, 4 ), ( Z, 4 )]
    L : [( B, 4 ), ( W, 1 )]
    R : [( Z, 5 )]
    W : [( F, 4 ), ( L, 1 )]
    Z : [( F, 4 ), ( R, 5 )]

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

A short snippet describing the license (MIT, Apache, etc.)
