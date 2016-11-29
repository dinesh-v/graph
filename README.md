## Synopsis

At the top of the file there should be a short introduction and/ or overview that explains **what** the project is. This description should match descriptions added for package managers (Gemspec, package.json, etc.)

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

## Motivation

A short description of the motivation behind the creation and maintenance of the project. This should explain **why** the project exists.

## Installation

Provide code examples and explanations of how to get the project.

## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests

Describe and show how to run the tests with code examples.

# __Example__ # : Graph in Adjacency list

    A : [( B, 2 ), ( C, 12 ), ( D, 7 )]
    B : [( A, 2 ), ( C, 1 ), ( L, 4 )]
    R : [( Z, 5 )]
    C : [( A, 12 ), ( B, 1 ), ( D, 1 )]
    D : [( A, 7 ), ( C, 1 ), ( F, 1 )]
    F : [( W, 4 ), ( Z, 4 ), ( D, 1 )]
    W : [( F, 4 ), ( L, 1 )]
    Z : [( F, 4 ), ( R, 5 )]
    L : [( B, 4 ), ( W, 1 )]

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

A short snippet describing the license (MIT, Apache, etc.)
