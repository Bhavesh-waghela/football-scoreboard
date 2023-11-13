# Live Football Scoreboard Library

## Introduction

This library provides a simple implementation of a Live Football Scoreboard. It supports operations such as starting a new match, updating the score, finishing a match, and getting a summary of matches in progress.

## Getting Started

To use this library, follow these steps:

1. Include the library in your project.
2. Create an instance of the `ScoreBoardServiceImpl` class.
3. Use the provided methods to interact with the scoreboard (start a match, update score, finish a match, get match summaries).

```java
// Example usage
ScoreBoardServiceImpl scoreBoardService = new ScoreBoardServiceImpl();
scoreboard.startMatch("Germany", "France");
scoreboard.updateScore("Germany", "France", new ScoreDto(2, 3));
List<MatchDto> summaries = scoreboard.getMatchesSummary();