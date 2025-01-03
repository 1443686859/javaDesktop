<p>给你一个字符串 <code>word</code>。如果 <code>word</code> 中同时出现某个字母 <code>c</code> 的小写形式和大写形式，并且<strong> 每个 </strong>小写形式的 <code>c</code> 都出现在第一个大写形式的 <code>c</code> 之前，则称字母 <code>c</code> 是一个 <strong>特殊字母</strong> 。</p>

<p>返回 <code>word</code> 中 <strong>特殊字母</strong> 的数量。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1:</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">word = "aaAbcBC"</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">3</span></p>

<p><strong>解释：</strong></p>

<p>特殊字母是 <code>'a'</code>、<code>'b'</code> 和 <code>'c'</code>。</p>

<p><strong class="example">示例 2:</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">word = "abc"</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">0</span></p>

<p><strong>解释：</strong></p>

<p><code>word</code> 中不存在特殊字母。</p>

<p><strong class="example">示例 3:</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">word = "AbBCab"</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">0</span></p>

<p><strong>解释：</strong></p>

<p><code>word</code> 中不存在特殊字母。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= word.length &lt;= 2 * 10<sup>5</sup></code></li> 
 <li><code>word</code> 仅由小写和大写英文字母组成。</li> 
</ul>

<div><li>👍 5</li><li>👎 0</li></div>