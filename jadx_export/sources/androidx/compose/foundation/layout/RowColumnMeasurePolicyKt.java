package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.RowColumnMeasurePolicy;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: RowColumnMeasurePolicy.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "mainAxisMin", "", "crossAxisMin", "mainAxisMax", "crossAxisMax", "arrangementSpacingInt", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "startIndex", "endIndex", "crossAxisOffset", "", "currentLineIndex", "(Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;IIIIILandroidx/compose/ui/layout/MeasureScope;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;II[II)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RowColumnMeasurePolicyKt {
    public static /* synthetic */ MeasureResult measure$default(RowColumnMeasurePolicy rowColumnMeasurePolicy, int i, int i2, int i3, int i4, int i5, MeasureScope measureScope, List list, Placeable[] placeableArr, int i6, int i7, int[] iArr, int i8, int i9, Object obj) {
        int[] iArr2;
        if ((i9 & 1024) == 0) {
            iArr2 = iArr;
        } else {
            iArr2 = null;
        }
        return measure(rowColumnMeasurePolicy, i, i2, i3, i4, i5, measureScope, list, placeableArr, i6, i7, iArr2, (i9 & 2048) != 0 ? 0 : i8);
    }

    public static final MeasureResult measure(RowColumnMeasurePolicy $this$measure, int mainAxisMin, int crossAxisMin, int mainAxisMax, int crossAxisMax, int arrangementSpacingInt, MeasureScope measureScope, List<? extends Measurable> list, Placeable[] placeables, int startIndex, int endIndex, int[] crossAxisOffset, int currentLineIndex) {
        long arrangementSpacingPx;
        int weightedSpace;
        int weightChildrenCount;
        String str;
        String str2;
        String str3;
        float weightUnitSpace;
        String str4;
        String str5;
        String str6;
        String str7;
        long remainingToTarget;
        int fixedSpace;
        int weightedSpace2;
        String str8;
        long arrangementSpacingTotal;
        String str9;
        int i;
        String str10;
        float totalWeight;
        int crossAxisSpace;
        int weightedSpace3;
        String str11;
        long remainingToTarget2;
        int targetSpace;
        int weightedSpace4;
        int fixedSpace2;
        float weightUnitSpace2;
        String str12;
        Integer numValueOf;
        FlowLayoutData it;
        long arrangementSpacingTotal2;
        int remainderUnit;
        String str13;
        float weightUnitSpace3;
        String str14;
        String str15;
        float weight;
        float weightedSize;
        int childMainAxisSize;
        long arrangementSpacingTotal3;
        int iIntValue;
        int crossAxisSpace2;
        int crossAxisSpace3;
        int i2;
        int afterCrossAxisAlignmentLine;
        int i3;
        int remaining;
        float totalWeight2;
        int crossAxisSpace4;
        int[] childrenMainAxisSize;
        long arrangementSpacingPx2;
        RowColumnMeasurePolicy rowColumnMeasurePolicy;
        int fixedSpace3;
        int subSize;
        int subSize2;
        FlowLayoutData it2;
        int i4 = crossAxisMax;
        List<? extends Measurable> list2 = list;
        int i5 = endIndex;
        long arrangementSpacingPx3 = arrangementSpacingInt;
        int subSize3 = i5 - startIndex;
        int[] childrenMainAxisSize2 = new int[subSize3];
        int afterCrossAxisAlignmentLine2 = 0;
        float totalWeight3 = 0.0f;
        int i6 = startIndex;
        boolean anyAlignBy = false;
        int weightChildrenCount2 = 0;
        int weightChildrenCount3 = 0;
        int crossAxisSpace5 = 0;
        int spaceAfterLastNoWeight = 0;
        while (true) {
            Integer crossAxisDesiredSize = null;
            boolean z = true;
            arrangementSpacingPx = arrangementSpacingPx3;
            if (i6 >= i5) {
                break;
            }
            Measurable child = list2.get(i6);
            RowColumnParentData parentData = RowColumnImplKt.getRowColumnParentData(child);
            float weight2 = RowColumnImplKt.getWeight(parentData);
            if (!anyAlignBy && !RowColumnImplKt.isRelative(parentData)) {
                z = false;
            }
            anyAlignBy = z;
            if (weight2 > 0.0f) {
                totalWeight3 += weight2;
                weightChildrenCount2++;
                i3 = i6;
                childrenMainAxisSize = childrenMainAxisSize2;
                arrangementSpacingPx2 = arrangementSpacingPx;
                subSize = subSize3;
            } else {
                if (i4 != Integer.MAX_VALUE && parentData != null && (it2 = parentData.getFlowLayoutData()) != null) {
                    float $this$fastRoundToInt$iv = it2.getFillCrossAxisFraction() * i4;
                    int $i$f$fastRoundToInt = Math.round($this$fastRoundToInt$iv);
                    crossAxisDesiredSize = Integer.valueOf($i$f$fastRoundToInt);
                }
                int remaining2 = mainAxisMax - crossAxisSpace5;
                Placeable placeableMo5535measureBRTryo0 = placeables[i6];
                if (placeableMo5535measureBRTryo0 == null) {
                    int iIntValue2 = crossAxisDesiredSize != null ? crossAxisDesiredSize.intValue() : 0;
                    int iCoerceAtLeast = mainAxisMax == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt.coerceAtLeast(remaining2, 0);
                    int iIntValue3 = crossAxisDesiredSize != null ? crossAxisDesiredSize.intValue() : i4;
                    i3 = i6;
                    totalWeight2 = totalWeight3;
                    crossAxisSpace4 = weightChildrenCount3;
                    int crossAxisSpace6 = iIntValue3;
                    rowColumnMeasurePolicy = $this$measure;
                    fixedSpace3 = crossAxisSpace5;
                    subSize = subSize3;
                    int fixedSpace4 = iCoerceAtLeast;
                    remaining = remaining2;
                    subSize2 = weightChildrenCount2;
                    childrenMainAxisSize = childrenMainAxisSize2;
                    arrangementSpacingPx2 = arrangementSpacingPx;
                    placeableMo5535measureBRTryo0 = child.mo5535measureBRTryo0(RowColumnMeasurePolicy.CC.m706createConstraintsxF2OJ5Q$default(rowColumnMeasurePolicy, 0, iIntValue2, fixedSpace4, crossAxisSpace6, false, 16, null));
                } else {
                    i3 = i6;
                    remaining = remaining2;
                    totalWeight2 = totalWeight3;
                    crossAxisSpace4 = weightChildrenCount3;
                    childrenMainAxisSize = childrenMainAxisSize2;
                    arrangementSpacingPx2 = arrangementSpacingPx;
                    rowColumnMeasurePolicy = $this$measure;
                    fixedSpace3 = crossAxisSpace5;
                    subSize = subSize3;
                    subSize2 = weightChildrenCount2;
                }
                Placeable placeable = placeableMo5535measureBRTryo0;
                int placeableMainAxisSize = rowColumnMeasurePolicy.mainAxisSize(placeable);
                int placeableCrossAxisSize = rowColumnMeasurePolicy.crossAxisSize(placeable);
                childrenMainAxisSize[i3 - startIndex] = placeableMainAxisSize;
                int spaceAfterLastNoWeight2 = Math.min(arrangementSpacingInt, RangesKt.coerceAtLeast(remaining - placeableMainAxisSize, 0));
                int crossAxisSpace7 = Math.max(crossAxisSpace4, placeableCrossAxisSize);
                placeables[i3] = placeable;
                spaceAfterLastNoWeight = spaceAfterLastNoWeight2;
                crossAxisSpace5 = fixedSpace3 + placeableMainAxisSize + spaceAfterLastNoWeight2;
                weightChildrenCount3 = crossAxisSpace7;
                totalWeight3 = totalWeight2;
                weightChildrenCount2 = subSize2;
            }
            i6 = i3 + 1;
            i4 = crossAxisMax;
            list2 = list;
            subSize3 = subSize;
            arrangementSpacingPx3 = arrangementSpacingPx2;
            childrenMainAxisSize2 = childrenMainAxisSize;
        }
        RowColumnMeasurePolicy rowColumnMeasurePolicy2 = $this$measure;
        float totalWeight4 = totalWeight3;
        int crossAxisSpace8 = weightChildrenCount3;
        int[] childrenMainAxisSize3 = childrenMainAxisSize2;
        int fixedSpace5 = crossAxisSpace5;
        int subSize4 = subSize3;
        int weightChildrenCount4 = weightChildrenCount2;
        int weightedSpace5 = 0;
        if (weightChildrenCount4 != 0) {
            int targetSpace2 = mainAxisMax != Integer.MAX_VALUE ? mainAxisMax : mainAxisMin;
            long arrangementSpacingTotal4 = (weightChildrenCount4 - 1) * arrangementSpacingPx;
            float totalWeight5 = totalWeight4;
            long remainingToTarget3 = RangesKt.coerceAtLeast((targetSpace2 - fixedSpace5) - arrangementSpacingTotal4, 0L);
            float weightUnitSpace4 = remainingToTarget3 / totalWeight5;
            long remainder = remainingToTarget3;
            int i7 = startIndex;
            while (true) {
                weightedSpace = crossAxisSpace8;
                weightChildrenCount = weightedSpace5;
                str = "remainingToTarget ";
                str2 = "weightedSize ";
                str3 = "arrangementSpacingTotal ";
                weightUnitSpace = weightUnitSpace4;
                str4 = "fixedSpace ";
                str5 = "weightUnitSpace ";
                str6 = "totalWeight ";
                str7 = "arrangementSpacingPx ";
                remainingToTarget = remainingToTarget3;
                if (i7 >= i5) {
                    break;
                }
                Measurable measurable = list.get(i7);
                int i8 = i7;
                float itemWeight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable));
                float weightedSize2 = weightUnitSpace * itemWeight;
                try {
                    remainder -= Math.round(weightedSize2);
                    i7 = i8 + 1;
                    i5 = endIndex;
                    crossAxisSpace8 = weightedSpace;
                    weightedSpace5 = weightChildrenCount;
                    weightUnitSpace4 = weightUnitSpace;
                    remainingToTarget3 = remainingToTarget;
                } catch (IllegalArgumentException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax ").append(mainAxisMax).append("mainAxisMin ").append(mainAxisMin).append("targetSpace ").append(targetSpace2).append("arrangementSpacingPx ").append(arrangementSpacingPx).append("weightChildrenCount ").append(weightChildrenCount4).append("fixedSpace ").append(fixedSpace5).append("arrangementSpacingTotal ").append(arrangementSpacingTotal4).append("remainingToTarget ").append(remainingToTarget).append(str6).append(totalWeight5).append(str5).append(weightUnitSpace).append("itemWeight ").append(itemWeight).append(str2);
                    sb.append(weightedSize2);
                    throw new IllegalArgumentException(sb.toString()).initCause(e);
                }
            }
            int fixedSpace6 = fixedSpace5;
            long remainingToTarget4 = remainingToTarget;
            int i9 = startIndex;
            while (true) {
                String str16 = str3;
                if (i9 >= endIndex) {
                    rowColumnMeasurePolicy2 = $this$measure;
                    crossAxisSpace8 = weightedSpace;
                    int crossAxisSpace9 = weightChildrenCount;
                    fixedSpace = fixedSpace6;
                    weightedSpace2 = RangesKt.coerceIn((int) (crossAxisSpace9 + arrangementSpacingTotal4), 0, mainAxisMax - fixedSpace);
                    break;
                }
                if (placeables[i9] == null) {
                    i = i9;
                    Measurable child2 = list.get(i9);
                    RowColumnParentData parentData2 = RowColumnImplKt.getRowColumnParentData(child2);
                    float weight3 = RowColumnImplKt.getWeight(parentData2);
                    if (crossAxisMax == Integer.MAX_VALUE || parentData2 == null || (it = parentData2.getFlowLayoutData()) == null) {
                        numValueOf = null;
                    } else {
                        float $this$fastRoundToInt$iv2 = it.getFillCrossAxisFraction() * crossAxisMax;
                        int $i$f$fastRoundToInt2 = Math.round($this$fastRoundToInt$iv2);
                        numValueOf = Integer.valueOf($i$f$fastRoundToInt2);
                    }
                    Integer crossAxisDesiredSize2 = numValueOf;
                    if (!(weight3 > 0.0f)) {
                        throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                    }
                    int remainderUnit2 = MathKt.getSign(remainder);
                    String str17 = str7;
                    remainder -= remainderUnit2;
                    float weightedSize3 = weightUnitSpace * weight3;
                    String str18 = str;
                    int childMainAxisSize2 = Math.max(0, Math.round(weightedSize3) + remainderUnit2);
                    try {
                        if (!RowColumnImplKt.getFill(parentData2) || childMainAxisSize2 == Integer.MAX_VALUE) {
                            arrangementSpacingTotal3 = arrangementSpacingTotal4;
                            childMainAxisSize = childMainAxisSize2;
                            childMainAxisSize2 = 0;
                        } else {
                            arrangementSpacingTotal3 = arrangementSpacingTotal4;
                            childMainAxisSize = childMainAxisSize2;
                        }
                        if (crossAxisDesiredSize2 != null) {
                            try {
                                iIntValue = crossAxisDesiredSize2.intValue();
                            } catch (IllegalArgumentException e2) {
                                e = e2;
                                str9 = str4;
                                remainderUnit = remainderUnit2;
                                totalWeight = totalWeight5;
                                str13 = str2;
                                weightUnitSpace3 = weightUnitSpace;
                                str14 = str5;
                                str15 = str6;
                                weight = weight3;
                                weightedSize = weightedSize3;
                                str8 = str18;
                                arrangementSpacingTotal2 = arrangementSpacingTotal3;
                                weightedSpace4 = weightChildrenCount4;
                                fixedSpace2 = fixedSpace6;
                                str12 = str17;
                                StringBuilder sb2 = new StringBuilder();
                                int weightChildrenCount5 = weightedSpace4;
                                sb2.append("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax ").append(mainAxisMax).append("mainAxisMin ").append(mainAxisMin).append("targetSpace ").append(targetSpace2).append(str12).append(arrangementSpacingPx).append("weightChildrenCount ").append(weightChildrenCount5).append(str9).append(fixedSpace2).append(str16).append(arrangementSpacingTotal2).append(str8).append(remainingToTarget4).append(str15).append(totalWeight).append(str14).append(weightUnitSpace3).append("weight ").append(weight).append(str13);
                                IllegalArgumentException e3 = e;
                                sb2.append(weightedSize).append("crossAxisDesiredSize ").append(crossAxisDesiredSize2).append("remainderUnit ").append(remainderUnit).append("childMainAxisSize ").append(childMainAxisSize);
                                throw new IllegalArgumentException(sb2.toString()).initCause(e3);
                            }
                        } else {
                            iIntValue = 0;
                        }
                        str9 = str4;
                        totalWeight = totalWeight5;
                        crossAxisSpace2 = weightedSpace;
                        crossAxisSpace3 = weightChildrenCount;
                        str13 = str2;
                        weightUnitSpace3 = weightUnitSpace;
                        str14 = str5;
                        str15 = str6;
                        weight = weight3;
                        weightedSize = weightedSize3;
                        remainderUnit = remainderUnit2;
                        str8 = str18;
                        arrangementSpacingTotal2 = arrangementSpacingTotal3;
                        weightedSpace4 = weightChildrenCount4;
                        fixedSpace2 = fixedSpace6;
                        str12 = str17;
                    } catch (IllegalArgumentException e4) {
                        e = e4;
                        arrangementSpacingTotal2 = arrangementSpacingTotal4;
                        str9 = str4;
                        remainderUnit = remainderUnit2;
                        totalWeight = totalWeight5;
                        str13 = str2;
                        weightUnitSpace3 = weightUnitSpace;
                        str14 = str5;
                        str15 = str6;
                        weight = weight3;
                        weightedSize = weightedSize3;
                        str8 = str18;
                        childMainAxisSize = childMainAxisSize2;
                        weightedSpace4 = weightChildrenCount4;
                        fixedSpace2 = fixedSpace6;
                        str12 = str17;
                    }
                    try {
                        long childConstraints = $this$measure.mo595createConstraintsxF2OJ5Q(childMainAxisSize2, iIntValue, childMainAxisSize, crossAxisDesiredSize2 != null ? crossAxisDesiredSize2.intValue() : crossAxisMax, true);
                        Placeable placeable2 = child2.mo5535measureBRTryo0(childConstraints);
                        int placeableMainAxisSize2 = $this$measure.mainAxisSize(placeable2);
                        int placeableCrossAxisSize2 = $this$measure.crossAxisSize(placeable2);
                        childrenMainAxisSize3[i - startIndex] = placeableMainAxisSize2;
                        weightedSpace3 = crossAxisSpace3 + placeableMainAxisSize2;
                        crossAxisSpace = Math.max(crossAxisSpace2, placeableCrossAxisSize2);
                        placeables[i] = placeable2;
                        str10 = str16;
                        remainingToTarget2 = remainingToTarget4;
                        arrangementSpacingTotal = arrangementSpacingTotal2;
                        str11 = str13;
                        str5 = str14;
                        str6 = str15;
                        targetSpace = targetSpace2;
                        weightUnitSpace2 = weightUnitSpace3;
                    } catch (IllegalArgumentException e5) {
                        e = e5;
                        StringBuilder sb22 = new StringBuilder();
                        int weightChildrenCount52 = weightedSpace4;
                        sb22.append("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax ").append(mainAxisMax).append("mainAxisMin ").append(mainAxisMin).append("targetSpace ").append(targetSpace2).append(str12).append(arrangementSpacingPx).append("weightChildrenCount ").append(weightChildrenCount52).append(str9).append(fixedSpace2).append(str16).append(arrangementSpacingTotal2).append(str8).append(remainingToTarget4).append(str15).append(totalWeight).append(str14).append(weightUnitSpace3).append("weight ").append(weight).append(str13);
                        IllegalArgumentException e32 = e;
                        sb22.append(weightedSize).append("crossAxisDesiredSize ").append(crossAxisDesiredSize2).append("remainderUnit ").append(remainderUnit).append("childMainAxisSize ").append(childMainAxisSize);
                        throw new IllegalArgumentException(sb22.toString()).initCause(e32);
                    }
                } else {
                    str8 = str;
                    arrangementSpacingTotal = arrangementSpacingTotal4;
                    str9 = str4;
                    i = i9;
                    str10 = str16;
                    totalWeight = totalWeight5;
                    crossAxisSpace = weightedSpace;
                    weightedSpace3 = weightChildrenCount;
                    str11 = str2;
                    remainingToTarget2 = remainingToTarget4;
                    targetSpace = targetSpace2;
                    weightedSpace4 = weightChildrenCount4;
                    fixedSpace2 = fixedSpace6;
                    weightUnitSpace2 = weightUnitSpace;
                    str12 = str7;
                }
                int weightedSpace6 = weightedSpace3;
                weightedSpace = crossAxisSpace;
                str3 = str10;
                str2 = str11;
                weightUnitSpace = weightUnitSpace2;
                str7 = str12;
                targetSpace2 = targetSpace;
                fixedSpace6 = fixedSpace2;
                weightChildrenCount4 = weightedSpace4;
                remainingToTarget4 = remainingToTarget2;
                totalWeight5 = totalWeight;
                str = str8;
                str4 = str9;
                weightChildrenCount = weightedSpace6;
                i9 = i + 1;
                arrangementSpacingTotal4 = arrangementSpacingTotal;
            }
        } else {
            fixedSpace = fixedSpace5 - spaceAfterLastNoWeight;
            weightedSpace2 = 0;
        }
        if (anyAlignBy) {
            int i10 = startIndex;
            int beforeCrossAxisAlignmentLine = 0;
            int afterCrossAxisAlignmentLine3 = 0;
            while (true) {
                i2 = endIndex;
                if (i10 >= i2) {
                    break;
                }
                Placeable placeable3 = placeables[i10];
                Intrinsics.checkNotNull(placeable3);
                CrossAxisAlignment crossAxisAlignment = RowColumnImplKt.getCrossAxisAlignment(RowColumnImplKt.getRowColumnParentData(placeable3));
                Integer alignmentLinePosition = crossAxisAlignment != null ? crossAxisAlignment.calculateAlignmentLinePosition$foundation_layout_release(placeable3) : null;
                if (alignmentLinePosition != null) {
                    int it3 = alignmentLinePosition.intValue();
                    int placeableCrossAxisSize3 = rowColumnMeasurePolicy2.crossAxisSize(placeable3);
                    beforeCrossAxisAlignmentLine = Math.max(beforeCrossAxisAlignmentLine, it3 != Integer.MIN_VALUE ? alignmentLinePosition.intValue() : 0);
                    afterCrossAxisAlignmentLine3 = Math.max(afterCrossAxisAlignmentLine3, placeableCrossAxisSize3 - (it3 != Integer.MIN_VALUE ? it3 : placeableCrossAxisSize3));
                }
                i10++;
            }
            afterCrossAxisAlignmentLine2 = afterCrossAxisAlignmentLine3;
            afterCrossAxisAlignmentLine = beforeCrossAxisAlignmentLine;
        } else {
            i2 = endIndex;
            afterCrossAxisAlignmentLine = 0;
        }
        int mainAxisLayoutSize = Math.max(RangesKt.coerceAtLeast(fixedSpace + weightedSpace2, 0), mainAxisMin);
        int crossAxisLayoutSize = Math.max(crossAxisSpace8, Math.max(crossAxisMin, afterCrossAxisAlignmentLine + afterCrossAxisAlignmentLine2));
        int[] mainAxisPositions = new int[subSize4];
        for (int i11 = 0; i11 < subSize4; i11++) {
            mainAxisPositions[i11] = 0;
        }
        rowColumnMeasurePolicy2.populateMainAxisPositions(mainAxisLayoutSize, childrenMainAxisSize3, mainAxisPositions, measureScope);
        return rowColumnMeasurePolicy2.placeHelper(placeables, measureScope, afterCrossAxisAlignmentLine, mainAxisPositions, mainAxisLayoutSize, crossAxisLayoutSize, crossAxisOffset, currentLineIndex, startIndex, i2);
    }
}
