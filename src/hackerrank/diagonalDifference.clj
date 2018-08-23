(ns diagonalDifference
  (:require [nrepl.server :as nrepl-server]))

(def arr [[1 2 1] [1 2 3] [1 2 3]])

(defn update [m k f]
  (assoc m k (f (get m k))))
 
(defn diagonalDifference [arr]
  (let [n (count arr)
        acc (reduce (fn [acc [d1 d2]] (let [acc* (update acc :d1 #(+ d1 %))
                                            acc** (update acc* :d2 #(+ d2 %))] acc**))
                    {:d1 0 :d2 0}
                    (for [i (range n)]
                      (let [j (- (dec n) i)]
                        [(nth (nth arr i) i)
                         (nth (nth arr i) j)])))]
    (Math/abs (- (:d2 acc) (:d1 acc)))))

(diagonalDifference arr)

(-
 (reduce + [1 2 3])
 (reduce + [1 2 1]))

