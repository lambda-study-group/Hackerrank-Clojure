(defn signedDiagonalDiff [matrix]
  (reduce
    (fn [sum pair] (+ sum (- (first pair) (last pair))))
    0
    (let [last-i (dec (count (first matrix)))]
      (map-indexed (fn [i line]
                     (vector (nth line i) (nth line (- last-i i))))
                   matrix))))

; Receives an array of arrays
(defn diagonalDifference [matrix]
  (let [diff (signedDiagonalDiff matrix)]
    (if (neg? diff) (- diff) diff)))

