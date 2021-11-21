from typing import List


class Point:
    def __init__(self, x1, x2, h, is_start, index):
        self.x1 = x1
        self.x2 = x2
        self.x1 = x1
        self.is_start = is_start
        self.index = index

class Skyline:

    def calc(self):
        buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]

        #buildings = [[1,2,10],[2,3,15],[1,7,12], [7,9,10],[3,7,15],[7,8,12],[7,20,10],[1,7,8]]
        self.getSkyline(buildings)
    
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        points = self.getSortedPoints(buildings)

        for point in points:
            print(f'is_start={point.is_start}; x1={point.x1}; x2={point.x2}')

        return None

    def getSortedPoints(self, buildings: List[List[int]]) -> List[Point]:
        points = []

        for i, building in enumerate(buildings):
            start = Point(building[0], building[1], building[2], True, i)
            end = Point(building[1], building[0], building[2], False, i)
            points.append(start)
            points.append(end)

        points.sort(key=lambda x: x.is_start, reverse=True)
        points.sort(key=lambda x: x.x1)
            
        return points