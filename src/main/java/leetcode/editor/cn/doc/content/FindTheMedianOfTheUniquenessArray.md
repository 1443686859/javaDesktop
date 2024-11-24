<p>给你一个整数数组 <code>nums</code> 。数组 <code>nums</code> 的<strong> 唯一性数组</strong> 是一个按元素从小到大排序的数组，包含了 <code>nums</code> 的所有非空 <span data-keyword="subarray-nonempty">子数组</span> 中不同元素的个数。</p>

<p>换句话说，这是由所有 <code>0 &lt;= i &lt;= j &lt; nums.length</code> 的 <code>distinct(nums[i..j])</code> 组成的递增数组。</p>

<p>其中，<code>distinct(nums[i..j])</code> 表示从下标 <code>i</code> 到下标 <code>j</code> 的子数组中不同元素的数量。</p>

<p>返回 <code>nums</code> <strong>唯一性数组 </strong>的 <strong>中位数 </strong>。</p>

<p><strong>注意</strong>，数组的 <strong>中位数 </strong>定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
 <!-- notionvc: 7e0f5178-4273-4a82-95ce-3395297921dc --></p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">nums = [1,2,3]</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">1</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 的唯一性数组为 <code>[distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]), distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]</code>，即 <code>[1, 1, 1, 2, 2, 3]</code> 。唯一性数组的中位数为 1 ，因此答案是 1 。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">nums = [3,4,3,4,5]</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 的唯一性数组为 <code>[1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3]</code> 。唯一性数组的中位数为 2 ，因此答案是 2 。</p>

<p><strong class="example">示例 3：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong><span class="example-io">nums = [4,3,5,4]</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">2</span></p>

<p><strong>解释：</strong></p>

<p><code>nums</code> 的唯一性数组为 <code>[1, 1, 1, 1, 2, 2, 2, 3, 3, 3]</code> 。唯一性数组的中位数为 2 ，因此答案是 2 。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<div><li>👍 35</li><li>👎 0</li></div>