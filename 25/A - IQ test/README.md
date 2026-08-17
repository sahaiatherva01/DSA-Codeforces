<h2><a href="https://codeforces.com/contest/25/problem/A" target="_blank" rel="noopener noreferrer">25A — IQ test</a></h2>

| | |
|---|---|
| **Difficulty** | 1300 |
| **Language** | Java 21 |
| **Verdict** | ✅ Accepted |
| **Problem Link** | [Codeforces 25A](https://codeforces.com/contest/25/problem/A) |

## Topics
`brute force`

---

## Problem Statement

<div class="header"><div class="title">A. IQ test</div><div class="time-limit"><div class="property-title">time limit per test</div>2 seconds</div><div class="memory-limit"><div class="property-title">memory limit per test</div>256 megabytes</div><div class="input-file input-standard" style="font-weight: bold"><div class="property-title">input</div>stdin</div><div class="output-file output-standard" style="font-weight: bold"><div class="property-title">output</div>stdout</div></div><div><p>Bob is preparing to pass IQ test. The most frequent task in this test is to find out which one of the given <span class="tex-span"><i>n</i></span> numbers differs from the others. Bob observed that one number usually differs from the others in evenness. Help Bob — to check his answers, he needs a program that among the given <span class="tex-span"><i>n</i></span> numbers finds one that is different in evenness.</p></div><div class="input-specification"><div class="section-title">Input</div><p>The first line contains integer <span class="tex-span"><i>n</i></span> (<span class="tex-span">3 ≤ <i>n</i> ≤ 100</span>) — amount of numbers in the task. The second line contains <span class="tex-span"><i>n</i></span> space-separated natural numbers, not exceeding 100. It is guaranteed, that exactly one of these numbers differs from the others in evenness.</p></div><div class="output-specification"><div class="section-title">Output</div><p>Output index of number that differs from the others in evenness. Numbers are numbered from 1 in the input order.</p></div><div class="sample-tests"><div class="section-title">Examples</div><div class="sample-test"><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id004585053594305045" id="id0010798263718285328" class="input-output-copier">Copy</div></div><pre id="id004585053594305045">5<br>2 4 7 8 10<br></pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id0011002220897767068" id="id00016142426187112258" class="input-output-copier">Copy</div></div><pre id="id0011002220897767068">3<br></pre></div><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id00721325089365718" id="id0021041439626862413" class="input-output-copier">Copy</div></div><pre id="id00721325089365718">4<br>1 2 1 1<br></pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id005718164960202766" id="id001862653115059668" class="input-output-copier">Copy</div></div><pre id="id005718164960202766">2<br></pre></div></div></div>