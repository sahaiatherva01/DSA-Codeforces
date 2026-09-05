<h2><a href="https://codeforces.com/contest/1560/problem/A" target="_blank" rel="noopener noreferrer">1560A — Dislike of Threes</a></h2>

| | |
|---|---|
| **Difficulty** | 800 |
| **Language** | Java 21 |
| **Verdict** | ✅ Accepted |
| **Problem Link** | [Codeforces 1560A](https://codeforces.com/contest/1560/problem/A) |

## Topics
`implementation`

---

## Problem Statement

<div class="header"><div class="title">A. Dislike of Threes</div><div class="time-limit"><div class="property-title">time limit per test</div>1 second</div><div class="memory-limit"><div class="property-title">memory limit per test</div>256 megabytes</div><div class="input-file input-standard"><div class="property-title">input</div>standard input</div><div class="output-file output-standard"><div class="property-title">output</div>standard output</div></div><div><p>Polycarp doesn't like integers that are divisible by <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-1"><span class="MJXp-mn" id="MJXp-Span-2">3</span></span></span>$3$ or end with the digit <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-3"><span class="MJXp-mn" id="MJXp-Span-4">3</span></span></span>$3$ in their decimal representation. Integers that meet both conditions are disliked by Polycarp, too.</p><p>Polycarp starts to write out the positive (greater than <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-5"><span class="MJXp-mn" id="MJXp-Span-6">0</span></span></span>$0$) integers which he likes: <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-7"><span class="MJXp-mn" id="MJXp-Span-8">1</span><span class="MJXp-mo" id="MJXp-Span-9" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-10">2</span><span class="MJXp-mo" id="MJXp-Span-11" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-12">4</span><span class="MJXp-mo" id="MJXp-Span-13" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-14">5</span><span class="MJXp-mo" id="MJXp-Span-15" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-16">7</span><span class="MJXp-mo" id="MJXp-Span-17" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-18">8</span><span class="MJXp-mo" id="MJXp-Span-19" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-20">10</span><span class="MJXp-mo" id="MJXp-Span-21" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-22">11</span><span class="MJXp-mo" id="MJXp-Span-23" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-24">14</span><span class="MJXp-mo" id="MJXp-Span-25" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mn" id="MJXp-Span-26">16</span><span class="MJXp-mo" id="MJXp-Span-27" style="margin-left: 0em; margin-right: 0.222em;">,</span><span class="MJXp-mo" id="MJXp-Span-28" style="margin-left: 0em; margin-right: 0em;">…</span></span></span>$1, 2, 4, 5, 7, 8, 10, 11, 14, 16, \dots$. Output the <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-29"><span class="MJXp-mi MJXp-italic" id="MJXp-Span-30">k</span></span></span>$k$-th element of this sequence (the elements are numbered from <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-31"><span class="MJXp-mn" id="MJXp-Span-32">1</span></span></span>$1$).</p></div><div class="input-specification"><div class="section-title">Input</div><p>The first line contains one integer <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-33"><span class="MJXp-mi MJXp-italic" id="MJXp-Span-34">t</span></span></span>$t$ (<span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-35"><span class="MJXp-mn" id="MJXp-Span-36">1</span><span class="MJXp-mo" id="MJXp-Span-37" style="margin-left: 0.333em; margin-right: 0.333em;">≤</span><span class="MJXp-mi MJXp-italic" id="MJXp-Span-38">t</span><span class="MJXp-mo" id="MJXp-Span-39" style="margin-left: 0.333em; margin-right: 0.333em;">≤</span><span class="MJXp-mn" id="MJXp-Span-40">100</span></span></span>$1 \le t \le 100$) — the number of test cases. Then <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-41"><span class="MJXp-mi MJXp-italic" id="MJXp-Span-42">t</span></span></span>$t$ test cases follow.</p><p>Each test case consists of one line containing one integer <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-43"><span class="MJXp-mi MJXp-italic" id="MJXp-Span-44">k</span></span></span>$k$ (<span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-45"><span class="MJXp-mn" id="MJXp-Span-46">1</span><span class="MJXp-mo" id="MJXp-Span-47" style="margin-left: 0.333em; margin-right: 0.333em;">≤</span><span class="MJXp-mi MJXp-italic" id="MJXp-Span-48">k</span><span class="MJXp-mo" id="MJXp-Span-49" style="margin-left: 0.333em; margin-right: 0.333em;">≤</span><span class="MJXp-mn" id="MJXp-Span-50">1000</span></span></span>$1 \le k \le 1000$).</p></div><div class="output-specification"><div class="section-title">Output</div><p>For each test case, output in a separate line one integer <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-51"><span class="MJXp-mi MJXp-italic" id="MJXp-Span-52">x</span></span></span>$x$ — the <span class="MathJax_Preview" style="color: inherit;"><span class="MJXp-math" id="MJXp-Span-53"><span class="MJXp-mi MJXp-italic" id="MJXp-Span-54">k</span></span></span>$k$-th element of the sequence that was written out by Polycarp.</p></div><div class="sample-tests"><div class="section-title">Example</div><div class="sample-test"><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id002254968857321753" id="id002649834236925297" class="input-output-copier">Copy</div></div><pre id="id002254968857321753">10
1
2
3
4
5
6
7
8
9
1000
</pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id00026713970863891823" id="id005747035394359007" class="input-output-copier">Copy</div></div><pre id="id00026713970863891823">1
2
4
5
7
8
10
11
14
1666
</pre></div></div></div>