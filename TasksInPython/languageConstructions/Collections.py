from heapq import heappop, heappush, heapify
from collections import deque

class Solution:
    """
    @param s: a string
    @param k: an integer
    @return: a string such that the same characters are at least distance k from each other
    """
    def rearrangeString(self, s, k):
        # Write your code here
        s = "aaabc"
        res = []
        dic = {}
        for c in s:
            dic[c] = dic.get(c, 0) + 1

        pq = []

        for c in dic:
            heappush(pq, (-dic[c], c))

        dq = deque()

        while pq:
            e = heappop(pq)
            c = e[1]
            newCount = -e[0] - 1
            res.append(c)

            dq.append((c, newCount))

            if len(dq) >= k:
                dqItem = dq.popleft()
                if dqItem[1] != 0:
                    heappush(pq, (-dqItem[1], dqItem[0]))
            
        if len(dq) != 0:
            e = dq.popleft()
            if e[1] != 0:
                return ""

        # while pq:
        #     e = heappop(pq)
        #     print (f' {e[1]} = {e[0]}')

        # while dq:
        #     e = dq.popleft()
        #     print (f' {e[0]} = {e[1]}')

       

        return "".join(res)
