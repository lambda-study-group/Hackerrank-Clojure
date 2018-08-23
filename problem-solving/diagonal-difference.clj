(defn signedDiagonalDiff [matrix]
  (reduce
    #(->> %2 (reduce -) (+ %1))
    0
    (let [last-i (dec (count (first matrix)))]
      (map-indexed (fn [i line]
                     (vector (nth line i) (nth line (- last-i i))))
                   matrix))))

; Receives an array of arrays
(defn diagonalDifference [matrix]
  (let [diff (signedDiagonalDiff matrix)]
    (if (neg? diff) (- diff) diff)))
