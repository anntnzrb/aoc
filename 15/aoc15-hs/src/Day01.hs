module Day01 where

-- | Given a character, returns 1 if it is an opening parenthesis '(' and -1 if
-- it is a closing parenthesis ')'.
countFloors :: (Num a) => Char -> a
countFloors '(' = 1
countFloors ')' = -1

findFirstBasement :: String -> Int
findFirstBasement = go 0 0
  where
    go :: Int -> Int -> String -> Int
    go _ _ [] = 0
    go idx (-1) _ = idx
    go idx floor (x : xs) = go (idx + 1) (floor + countFloors x) xs

{- ------------------------------------------------------------------------- -}

part1 :: String -> String
part1 =
  show
    . sum
    . map countFloors

part2 :: String -> String
part2 =
  show
    . findFirstBasement