<p>给出两个字符串&nbsp;<code>str1</code> 和&nbsp;<code>str2</code>，返回同时以&nbsp;<code>str1</code>&nbsp;和&nbsp;<code>str2</code>&nbsp;作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。</p>

<p>（如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的&nbsp;<strong>任意位置</strong>），可以得到字符串 S，那么&nbsp;S 就是&nbsp;T 的子序列）</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>str1 = "abac", str2 = "cab"
<strong>输出：</strong>"cabac"
<strong>解释：</strong>
str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。 
str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
最终我们给出的答案是满足上述属性的最短字符串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li><code>1 &lt;= str1.length, str2.length &lt;= 1000</code></li> 
 <li><code>str1</code> 和&nbsp;<code>str2</code>&nbsp;都由小写英文字母组成。</li> 
</ol>

<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 211</li><li>👎 0</li></div>