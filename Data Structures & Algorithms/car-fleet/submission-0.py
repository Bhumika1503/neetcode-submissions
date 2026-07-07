class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars=sorted(zip(position,speed),reverse=True)
        Fleets=0
        lt=0
        for pos,spd in cars:
            time=(target-pos)/spd
            if time>lt:
                Fleets+=1
                lt=time

        return Fleets                
