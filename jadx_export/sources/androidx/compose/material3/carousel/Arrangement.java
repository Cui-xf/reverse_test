package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Arrangement.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeCount", "()I", "getLargeSize", "()F", "getMediumCount", "getMediumSize", "getSmallCount", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "itemCount", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int priority, float smallSize, int smallCount, float mediumSize, int mediumCount, float largeSize, int largeCount) {
        this.priority = priority;
        this.smallSize = smallSize;
        this.smallCount = smallCount;
        this.mediumSize = mediumSize;
        this.mediumCount = mediumCount;
        this.largeSize = largeSize;
        this.largeCount = largeCount;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    private final boolean isValid() {
        return (this.largeCount <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) ? this.largeCount <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize : this.largeSize > this.mediumSize && this.mediumSize > this.smallSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float cost(float targetLargeSize) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(targetLargeSize - this.largeSize) * this.priority;
    }

    public final int itemCount() {
        return this.largeCount + this.mediumCount + this.smallCount;
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JX\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013J`\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float availableSpace, float itemSpacing, float targetSmallSize, float minSmallSize, float maxSmallSize, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
            int[] iArr = smallCounts;
            Arrangement lowestCostArrangement = null;
            int priority = 1;
            int length = largeCounts.length;
            int i = 0;
            while (i < length) {
                int largeCount = largeCounts[i];
                int length2 = mediumCounts.length;
                int i2 = 0;
                while (i2 < length2) {
                    int mediumCount = mediumCounts[i2];
                    int length3 = iArr.length;
                    int i3 = 0;
                    while (i3 < length3) {
                        int i4 = i2;
                        int smallCount = iArr[i3];
                        Arrangement lowestCostArrangement2 = lowestCostArrangement;
                        int i5 = i;
                        int i6 = length2;
                        int i7 = length3;
                        int i8 = i3;
                        Arrangement arrangement = fit(priority, availableSpace, itemSpacing, smallCount, targetSmallSize, minSmallSize, maxSmallSize, mediumCount, targetMediumSize, largeCount, targetLargeSize);
                        if (lowestCostArrangement2 == null || arrangement.cost(targetLargeSize) < lowestCostArrangement2.cost(targetLargeSize)) {
                            lowestCostArrangement2 = arrangement;
                            if (lowestCostArrangement2.cost(targetLargeSize) == 0.0f) {
                                return lowestCostArrangement2;
                            }
                        }
                        priority++;
                        i3 = i8 + 1;
                        lowestCostArrangement = lowestCostArrangement2;
                        i = i5;
                        length2 = i6;
                        i2 = i4;
                        length3 = i7;
                        iArr = smallCounts;
                    }
                    i2++;
                    iArr = smallCounts;
                }
                i++;
                iArr = smallCounts;
            }
            return lowestCostArrangement;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final androidx.compose.material3.carousel.Arrangement fit(int r15, float r16, float r17, int r18, float r19, float r20, float r21, int r22, float r23, int r24, float r25) {
            /*
                r14 = this;
                r2 = r18
                r4 = r22
                r5 = r24
                int r0 = r5 + r4
                int r8 = r0 + r2
                int r0 = r8 + (-1)
                float r0 = (float) r0
                float r0 = r0 * r17
                float r1 = r16 - r0
                float r0 = kotlin.ranges.RangesKt.coerceIn(r19, r20, r21)
                r6 = r23
                r7 = r25
                float r3 = (float) r5
                float r3 = r3 * r7
                float r9 = (float) r4
                float r9 = r9 * r6
                float r3 = r3 + r9
                float r9 = (float) r2
                float r9 = r9 * r0
                float r3 = r3 + r9
                r9 = r3
                float r10 = r1 - r9
                r11 = 0
                if (r2 <= 0) goto L39
                int r3 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
                if (r3 <= 0) goto L39
                float r3 = (float) r2
                float r3 = r10 / r3
                float r12 = r21 - r0
                float r3 = java.lang.Math.min(r3, r12)
                float r0 = r0 + r3
                goto L49
            L39:
                if (r2 <= 0) goto L49
                int r3 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
                if (r3 >= 0) goto L49
                float r3 = (float) r2
                float r3 = r10 / r3
                float r12 = r20 - r0
                float r3 = java.lang.Math.max(r3, r12)
                float r0 = r0 + r3
            L49:
                if (r2 <= 0) goto L4d
                r3 = r0
                goto L4e
            L4d:
                r3 = 0
            L4e:
                r0 = r14
                float r12 = r0.calculateLargeSize(r1, r2, r3, r4, r5)
                r13 = r1
                r2 = r3
                float r3 = r12 + r2
                r0 = 1073741824(0x40000000, float:2.0)
                float r3 = r3 / r0
                if (r4 <= 0) goto L99
                int r0 = (r12 > r25 ? 1 : (r12 == r25 ? 0 : -1))
                if (r0 != 0) goto L68
                r0 = 1
                goto L69
            L68:
                r0 = 0
            L69:
                if (r0 != 0) goto L99
                float r0 = r25 - r12
                float r1 = (float) r5
                float r0 = r0 * r1
                r1 = 1036831949(0x3dcccccd, float:0.1)
                float r1 = r1 * r3
                float r6 = (float) r4
                float r1 = r1 * r6
                float r6 = java.lang.Math.abs(r0)
                float r6 = java.lang.Math.min(r6, r1)
                int r7 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
                if (r7 <= 0) goto L8f
                float r7 = (float) r4
                float r7 = r6 / r7
                float r3 = r3 - r7
                float r7 = (float) r5
                float r7 = r6 / r7
                float r12 = r12 + r7
                r6 = r12
                goto L9a
            L8f:
                float r7 = (float) r4
                float r7 = r6 / r7
                float r3 = r3 + r7
                float r7 = (float) r5
                float r7 = r6 / r7
                float r12 = r12 - r7
                r6 = r12
                goto L9a
            L99:
                r6 = r12
            L9a:
                androidx.compose.material3.carousel.Arrangement r0 = new androidx.compose.material3.carousel.Arrangement
                r1 = r15
                r7 = r5
                r5 = r4
                r4 = r3
                r3 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.Arrangement.Companion.fit(int, float, float, int, float, float, float, int, float, int, float):androidx.compose.material3.carousel.Arrangement");
        }

        private final float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
            return (availableSpace - ((smallCount + (mediumCount / 2.0f)) * smallSize)) / (largeCount + (mediumCount / 2.0f));
        }
    }
}
