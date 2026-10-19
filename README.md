# Data Structures & Graph Theory Algorithms Suite 🧠

[![Java](https://img.shields.io/badge/Java-21%2B-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![C++](https://img.shields.io/badge/C%2B%2B-17-00599C?style=flat-square&logo=c%2B%2B&logoColor=white)](https://isocpp.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg?style=flat-square)](LICENSE)
[![Build Status](https://img.shields.io/badge/Build-Passing_100%25-brightgreen?style=flat-square)]()

A robust collection of classical and advanced Graph Theory algorithms, traversal engines, cycle detection mechanisms, and Minimum Spanning Tree (MST) solvers implemented from scratch in pure Java and modern C++.

---

## 🗺️ Algorithmic Suite & Complexity Table

| Category | Algorithm / Problem | Implementation File | Time Complexity | Space Complexity |
|---|---|---|---|---|
| **Traversal** | Breadth-First Search (BFS) | `BFS.java` | $O(V + E)$ | $O(V)$ |
| **Traversal** | Depth-First Search (DFS) | `DFS.java` | $O(V + E)$ | $O(V)$ |
| **Connectivity** | Strongly Connected Components (Tarjan / Kosaraju) | `SCC.java` | $O(V + E)$ | $O(V)$ |
| **Connectivity** | Articulation Points (Cut Vertices) | `AP.java` | $O(V + E)$ | $O(V)$ |
| **Connectivity** | Bridges in Graphs | `BRIDGE.java` | $O(V + E)$ | $O(V)$ |
| **Cycle Detection**| Directed Graph Cycle Detection (DFS recursion stack) | `DETECTCYCLEINDC.java` | $O(V + E)$ | $O(V)$ |
| **Cycle Detection**| Undirected Graph Cycle Detection (Parent tracking) | `DETECTCYCLEINUDC.java` | $O(V + E)$ | $O(V)$ |
| **Ordering** | Topological Sort (Kahn's In-Degree / DFS) | `TOPOSORT.java` | $O(V + E)$ | $O(V)$ |
| **Shortest Path** | Dijkstra's Single-Source Shortest Path | `Dijkstra.java` | $O((V + E) \log V)$ | $O(V)$ |
| **Shortest Path** | Bellman-Ford Negative Weight Cycle Detection | `Belman.java`, `Belmanp.java` | $O(V \cdot E)$ | $O(V)$ |
| **Shortest Path** | Floyd-Warshall All-Pairs Shortest Path | `Floyed.java`, `FroyedWarshall.java` | $O(V^3)$ | $O(V^2)$ |
| **MST** | Kruskal's Algorithm (Disjoint Set Union) | `Krushkal.java`, `kruskalp.java` | $O(E \log E)$ | $O(V)$ |
| **MST** | Prim's Algorithm (Priority Queue) | `Prim.java`, `Primp.java` | $O((V + E) \log V)$ | $O(V)$ |

---

## 🛠️ How to Compile & Run

### 1. Compile any Java Algorithm
```bash
# Example: Dijkstra's Shortest Path
javac Dijkstra.java
java Dijkstra

# Example: Strongly Connected Components (SCC)
javac SCC.java
java SCC

# Example: Kruskal's Minimum Spanning Tree
javac Krushkal.java
java Krushkal
```

### 2. Compile C++ Snippets
```bash
g++ -O2 -std=c++17 snippets.cpp -o snippets.exe
./snippets.exe
```

---

## 👨‍💻 Author
**Tamal Kanti Sarker**  
Department of Computer Science and Engineering, University of Dhaka  
GitHub: [@tamalkantisarker](https://github.com/tamalkantisarker)
