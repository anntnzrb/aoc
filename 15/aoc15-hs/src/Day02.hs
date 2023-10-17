{-# LANGUAGE RecordWildCards #-}

module Day02 where

import Lib (wordsWhen)

data Dimensions = Dimensions
  { length :: Int,
    width :: Int,
    height :: Int
  }
  deriving (Show)

-- | This is a wrapper around 'parseDimensions''.
parseDimensions :: [String] -> [Dimensions]
parseDimensions = map parseDimensions'

-- | Parses a string representing dimensions and returns a 'Dimensions' object.
parseDimensions' :: String -> Dimensions
parseDimensions' s = Dimensions l w h
  where
    [l, w, h] = map read $ wordsWhen (== 'x') s

-- | This is a wrapper around 'calcSurfacesArea''.
calcSurfacesArea :: [Dimensions] -> [Int]
calcSurfacesArea = map calcSurfacesArea'

-- | Calculates the surface area of a rectangular box given its dimensions.
--
-- The surface area is calculated as the sum of the areas of each face of the
-- box.  The smallest face area is added as well to account for the wrapping
-- paper needed to cover the box.
calcSurfacesArea' :: Dimensions -> Int
calcSurfacesArea' Dimensions {..} = 2 * sum sides + smallestSide
  where
    sides :: [Int]
    sides = [length * width, width * height, height * length]

    smallestSide :: Int
    smallestSide = minimum sides

-- | This is a wrapper around 'calcWrappingRibbon''.
calcWrappingRibbon :: [Dimensions] -> [Int]
calcWrappingRibbon = map calcWrappingRibbon'

-- Calculates the amount of ribbon required to wrap a box with the given
-- dimensions.
--
-- The amount of ribbon required is twice the minimum perimeter of any face of
-- the box.
calcWrappingRibbon' :: Dimensions -> Int
calcWrappingRibbon' (Dimensions l w h) = 2 * minimum [l + w, w + h, h + l]

-- | This is a wrapper around 'calcBowRibbon''.
calcBowRibbon :: [Dimensions] -> [Int]
calcBowRibbon = map calcBowRibbon'

-- | Calculates the amount of ribbon needed for the bow of a box with the given
-- dimensions.
calcBowRibbon' :: Dimensions -> Int
calcBowRibbon' Dimensions {..} = length * width * height

-- | This is a wrapper around 'calcTotalRibbon''.
calcTotalRibbon :: [Dimensions] -> [Int]
calcTotalRibbon = map calcTotalRibbon'

-- | Calculates the total amount of ribbon needed for a gift box, including both
-- the wrapping and the bow.
calcTotalRibbon' :: Dimensions -> Int
calcTotalRibbon' dim = calcWrappingRibbon' dim + calcBowRibbon' dim

{- ------------------------------------------------------------------------- -}

part1 :: String -> String
part1 = show . sum . calcSurfacesArea . parseDimensions . lines

part2 :: String -> String
part2 = show . sum . calcTotalRibbon . parseDimensions . lines
