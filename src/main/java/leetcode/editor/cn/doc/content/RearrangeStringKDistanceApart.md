<p>给你一个非空的字符串&nbsp;<code>s</code>&nbsp;和一个整数&nbsp;<code>k</code>&nbsp;，你要将这个字符串&nbsp;<code>s</code>&nbsp;中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离 <strong>至少</strong> 为&nbsp;<code>k</code>&nbsp;。如果无法做到，请返回一个空字符串&nbsp;<code>""</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入: </strong>s = "aabbcc", k = 3
<strong>输出: </strong>"abcabc" 
<strong>解释: </strong>相同的字母在新的字符串中间隔至少 3 个单位距离。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "aaabc", k = 3
<strong>输出: </strong>"" 
<strong>解释:</strong> 没有办法找到可能的重排结果。
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre>
<strong>输入: </strong>s = "aaadbbcc", k = 2
<strong>输出: </strong>"abacabcd"
<strong>解释:</strong> 相同的字母在新的字符串中间隔至少 2 个单位距离。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li> 
 <li><code>s</code>&nbsp;仅由小写英文字母组成</li> 
 <li><code>0 &lt;= k &lt;= s.length</code></li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>哈希表</li><li>字符串</li><li>计数</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 102</li><li>👎 0</li></div>